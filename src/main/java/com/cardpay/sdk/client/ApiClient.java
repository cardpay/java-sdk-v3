package com.cardpay.sdk.client;

import static com.cardpay.sdk.model.OAuthError.NameEnum.TOKEN;
import static java.lang.System.currentTimeMillis;
import static java.lang.ThreadLocal.withInitial;
import static java.util.Optional.ofNullable;

import com.cardpay.sdk.api.AuthApi;
import com.cardpay.sdk.model.*;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Consumer;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static final String USER_AGENT = "CardpaySdk/2.13.10/Java";

    private TokenProvider tokenProvider;

    private String baseUrl;
    private String terminalCode;
    private String password;

    private Duration connectTimeout = Duration.ofMillis(40000);
    private Duration readTimeout = Duration.ofMillis(60000);
    private Duration callTimeout = Duration.ofMillis(100000);

    private Map<String, Interceptor> apiAuthorizations;
    private OkHttpClient.Builder okBuilder;
    private Retrofit.Builder adapterBuilder;
    private List<Interceptor> interceptors;

    public ApiClient() {
        this.interceptors = new ArrayList<>();
        this.apiAuthorizations = new LinkedHashMap<>();
    }

    public ApiClient(String baseUrl) {
        this();
        this.baseUrl = !baseUrl.endsWith("/") ? baseUrl + "/" : baseUrl;
    }

    public ApiClient(String baseUrl, TokenProvider tokenProvider) {
        this(baseUrl);
        this.tokenProvider = tokenProvider;
    }

    public ApiClient(String baseUrl, String terminalCode, String password) {
        this(baseUrl);
        this.terminalCode = terminalCode;
        this.password = password;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectTimeout(Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void setCallTimeout(Duration callTimeout) {
        this.callTimeout = callTimeout;
    }

    private void createDefaultAdapter() {
        this.okBuilder = new OkHttpClient.Builder()
                .addInterceptor(new UserAgentInterceptor(USER_AGENT))
                .connectTimeout(this.connectTimeout)
                .readTimeout(this.readTimeout)
                .callTimeout(this.callTimeout);

        interceptors.forEach(v -> okBuilder.addInterceptor(v));

        adapterBuilder = new Retrofit
                .Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonCustomConverterFactory.create(new JSON().getGson()));

        addAuthorization("Bearer", new TokenManagerInterceptor(
                ofNullable(this.tokenProvider)
                        .orElseGet(() -> new DefaultTokenProvider(
                                createService(AuthApi.class),
                                this.terminalCode,
                                this.password)
                        )
        ));
    }

    private Retrofit.Builder getAdapterBuilder() {
        if (adapterBuilder == null) {
            createDefaultAdapter();
        }
        return adapterBuilder;
    }

    public <S> S createService(Class<S> serviceClass) {
        return getAdapterBuilder()
                .client(okBuilder.build())
                .build()
                .create(serviceClass);
    }

    public ApiClient addLogging(HttpLoggingInterceptor.Level level) {
        this.interceptors.add(new HttpLoggingInterceptor().setLevel(level));
        return this;
    }

    /**
     * Adds an authorization to be used by the client
     *
     * @param authName      Authentication name
     * @param authorization Authorization interceptor
     * @return ApiClient
     */
    private ApiClient addAuthorization(String authName, Interceptor authorization) {
        if (apiAuthorizations.containsKey(authName)) {
            throw new RuntimeException("auth name \"" + authName + "\" already in api authorizations");
        }
        apiAuthorizations.put(authName, authorization);
        okBuilder.addInterceptor(authorization);
        return this;
    }

    public static com.cardpay.sdk.model.Request uuidRequest() {
        return new com.cardpay.sdk.model.Request()
                .id(UUID.randomUUID().toString())
                .time(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime());
    }

    public static <T> T fromJson(String json, Class<T> callbackClass) {
        try {
            return new JSON().getGson().fromJson(json, callbackClass);
        } catch (JsonSyntaxException e) {
            throw new CallbackException("Json parse exception", e);
        }
    }

    public static Response doGet(String url) throws ApiException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", ApiClient.USER_AGENT)
                .build();

        OkHttpClient client = new OkHttpClient();
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    public static String getContent(ResponseBody responseBody) {
        return ofNullable(responseBody)
                .map(body -> new Scanner(body.byteStream()).useDelimiter("\\A"))
                .filter(Scanner::hasNext)
                .map(Scanner::next)
                .orElse(null);
    }

    public static class ApiException extends IOException {

        public ApiException() {
        }

        public ApiException(String message) {
            super(message);
        }

        public ApiException(String message, Throwable cause) {
            super(message, cause);
        }

    }

    public static class CallbackException extends RuntimeException {

        public CallbackException() {
        }

        public CallbackException(String message) {
            super(message);
        }

        public CallbackException(String message, Throwable cause) {
            super(message, cause);
        }

    }

    public static class InvalidSignatureException extends RuntimeException {

        public InvalidSignatureException() {
        }

        public InvalidSignatureException(String message) {
            super(message);
        }

        public InvalidSignatureException(String message, Throwable cause) {
            super(message, cause);
        }

    }

    public static class CallbackProcessor {

        private JSON json;
        private String callbackSecret;
        private Map<String, Consumer<?>> handlers = new TreeMap<>();

        public CallbackProcessor(String callbackSecret) {
            this.json = new JSON();
            this.callbackSecret = callbackSecret;
        }

        public <T> CallbackProcessor registerHandler(Class<T> clazz, Consumer<T> handler) {
            handlers.put(clazz.getName(), handler);
            return this;
        }

        @SuppressWarnings("unchecked")
        public void process(String json, String signature) {
            if (!isValidSignature(json, signature)) {
                throw new ApiClient.InvalidSignatureException("Invalid callback signature");
            }

            Object obj = parseCallback(json);
            Consumer<Object> handler = (Consumer<Object>) handlers.get(obj.getClass().getName());
            if (handler == null) {
                throw new ApiClient.CallbackException("Not found handler for callback class " + obj.getClass().getName());
            }

            handler.accept(obj);
        }

        public <T> T fromJson(String json, Class<T> callbackClass) {
            try {
                return this.json.getGson().fromJson(json, callbackClass);
            } catch (JsonSyntaxException e) {
                throw new ApiClient.CallbackException("Json parse exception", e);
            }
        }

        public Object parseCallback(String json) {
            if (json == null || json.isEmpty()) {
                throw new ApiClient.CallbackException("Could not parse null or empty callback json.");
            }

            if (json.contains("refund_data")) {
                return this.fromJson(json, RefundCallback.class);
            } else if (json.contains("recurring_data")) {
                return this.fromJson(json, RecurringCallback.class);
            } else if (json.contains("payout_data")) {
                return this.fromJson(json, PayoutCallback.class);
            } else if (json.contains("payment_data")) {
                return this.fromJson(json, PaymentCallback.class);
            } else {
                throw new ApiClient.CallbackException("Could not parse callback json.");
            }
        }

        public boolean isValidSignature(String json, String signature) {
            return signature != null
                    && !signature.isEmpty()
                    && signature.equals(calcSignature(json));
        }

        public String calcSignature(String json) {
            String message = json + this.callbackSecret;

            try {
                MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
                digest.update(message.getBytes(StandardCharsets.UTF_8));
                // when using hexadecimal, you use two digits to represent one byte (from 0x00 to 0xFF) ; so, to store a binary value that can be
                // represented by 128 hexadecimal characters, you need 64 bytes
                int outputStringLength = digest.getDigestLength() * 2;
                String result = new BigInteger(1, digest.digest()).toString(16);
                // Adding leading zeroes because the signature must have the length exactly 128
                while (result.length() < outputStringLength) {
                    result = "0".concat(result);
                }
                return result;

            } catch (NoSuchAlgorithmException ex) {
                // Ignored
                return null;
            }
        }
    }

    public static IOException parseApiError(Response response) throws IOException {
        if (response.body() == null) {
            return new IOException("Unknown API error");
        } else {
            com.cardpay.sdk.model.ApiError apiError = new JSON().getGson().fromJson(response.body().string(), com.cardpay.sdk.model.ApiError.class);
            return new ApiClient.ApiException(apiError.getMessage());
        }
    }

    public interface TokenProvider {

        String obtainToken() throws IOException;

        String obtainNewToken() throws IOException;

    }
}

/**
 * This wrapper is to take care of this case:
 * when the deserialization fails due to JsonParseException and the
 * expected type is String, then just return the body string.
 */
class GsonResponseBodyConverterToString<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverterToString(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T convert(ResponseBody value) throws IOException {
        String returned = value.string();
        try {
            return gson.fromJson(returned, type);
        } catch (JsonParseException e) {
            return (T) returned;
        }
    }
}

class GsonCustomConverterFactory extends Converter.Factory {
    private final Gson gson;
    private final GsonConverterFactory gsonConverterFactory;

    public static GsonCustomConverterFactory create(Gson gson) {
        return new GsonCustomConverterFactory(gson);
    }

    private GsonCustomConverterFactory(Gson gson) {
        if (gson == null)
            throw new NullPointerException("gson == null");
        this.gson = gson;
        this.gsonConverterFactory = GsonConverterFactory.create(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type.equals(String.class))
            return new GsonResponseBodyConverterToString<Object>(gson, type);
        else
            return gsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return gsonConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}

class UserAgentInterceptor implements Interceptor {
    private String userAgent;

    UserAgentInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request userAgentRequest = chain.request()
                .newBuilder()
                .header("User-Agent", this.userAgent)
                .build();
        return chain.proceed(userAgentRequest);
    }
}

class DefaultTokenProvider implements ApiClient.TokenProvider {

    private static final long TOKEN_MIN_VALIDITY = 10000;

    private final JSON json = new JSON();

    private final String terminalCode;
    private final String password;
    private final AuthApi authApi;

    private ThreadLocal<ApiTokens> tokens = withInitial(() -> null);

    public DefaultTokenProvider(AuthApi authApi, String terminalCode, String password) {
        this.authApi = authApi;
        this.terminalCode = terminalCode;
        this.password = password;
    }

    @Override
    public String obtainToken() throws IOException {
        ApiTokens token = this.tokens.get();
        return token == null || isExpired(token.getExpiresIn())
                ? obtainNewToken()
                : token.getAccessToken();
    }

    @Override
    public String obtainNewToken() throws IOException {
        ApiTokens token = tokens.get();
        try {
            if (token == null
                    || token.getRefreshToken() == null
                    || isExpired(token.getRefreshExpiresIn())
            ) {
                token = obtainByPassword(password, terminalCode);
            } else {
                token = obtainByRefreshToken(token.getRefreshToken());
            }
        } catch (IOException e) {
            token = obtainByPassword(password, terminalCode);
        }

        token.setExpiresIn(token.getExpiresIn() * 1000 + currentTimeMillis());
        token.setRefreshExpiresIn(token.getRefreshExpiresIn() * 1000 + currentTimeMillis());

        tokens.set(token);
        return token.getAccessToken();
    }

    private ApiTokens obtainByRefreshToken(String refreshToken) throws IOException {
        retrofit2.Response<ApiTokens> response = authApi
                .obtainTokens("refresh_token", "", refreshToken, "")
                .execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw parseAuthError(response);
        }
    }

    private ApiTokens obtainByPassword(String password, String terminalCode) throws IOException {
        retrofit2.Response<ApiTokens> response = authApi
                .obtainTokens("password", password, "", terminalCode)
                .execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw parseAuthError(response);
        }
    }

    private IOException parseAuthError(retrofit2.Response<ApiTokens> response) throws IOException {
        if (response.errorBody() == null) {
            return new IOException("Unknown auth error");
        } else {
            OAuthError error = json.getGson().fromJson(response.errorBody().string(), OAuthError.class);
            return new ApiClient.ApiException(error.getMessage());
        }
    }

    private boolean isExpired(long expiresAt) {
        return expiresAt - currentTimeMillis() < TOKEN_MIN_VALIDITY;
    }
}

class TokenManagerInterceptor implements Interceptor {

    private final JSON json = new JSON();

    private final ApiClient.TokenProvider tokenProvider;

    TokenManagerInterceptor(ApiClient.TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (request.url().encodedPath().contains("/api/auth/token")) {
            return chain.proceed(request);
        }

        Response response = proceed(chain, request, tokenProvider.obtainToken());

        if (!response.isSuccessful() && response.body() != null) {
            if (isBadRequest(response)) {
                throw ApiClient.parseApiError(response);
            }

            OAuthError error = json.getGson().fromJson(response.body().string(), OAuthError.class);
            if (error.getName() != TOKEN) {
                throw new IOException(error.getMessage());
            }

            response = proceed(chain, request, tokenProvider.obtainNewToken());

            if (!response.isSuccessful() && response.body() != null) {
                throw ApiClient.parseApiError(response);
            }
        }

        return response;
    }

    private boolean isBadRequest(Response response) {
        return response.code() == HttpURLConnection.HTTP_BAD_REQUEST;
    }

    private Response proceed(Chain chain, Request request, String accessToken) throws IOException {
        return chain.proceed(
                request.newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken)
                        .build()
        );
    }

}
