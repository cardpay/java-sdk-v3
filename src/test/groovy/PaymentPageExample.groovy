import com.cardpay.sdk.api.PaymentsApi
import com.cardpay.sdk.client.ApiClient
import com.cardpay.sdk.model.PaymentRequest
import io.codearte.jfairy.Fairy

@Grab('com.cardpay:java-sdk:1.4.4')
@Grab('io.codearte.jfairy:jfairy:0.5.9')

ApiClient client = new ApiClient("https://sandbox.cardpay.com", "18397", "FpK2cy143POj")
PaymentsApi payments = client.createService(PaymentsApi.class)

def fairy = Fairy.create()
def text = fairy.textProducer()

def customerId = text.randomString(15)

def request = new PaymentRequest(
        request: client.uuidRequest(),
        paymentMethod: "BANKCARD",
        merchantOrder: [
                id         : text.randomString(15),
                description: text.sentence()
        ],
        customer: [
                id      : customerId,
                email   : customerId + '@mailinator.com',
                fullName: fairy.person().getFullName()
        ],
        paymentData: [
                currency: "USD",
                amount  : fairy.baseProducer().randomBetween(10, 300)
        ]
)

println request

def response = payments.createPayment(request).execute()
println response

println response.body()