# Unlimint API v3 Java SDK

You can sign up for a Unlimint account at https://www.unlimint.com.

## Getting Started

Please follow the [installation](#installation) instruction and take a look at [usage examples](src/test/java/com/cardpay/sdk).


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.cardpay</groupId>
  <artifactId>java-sdk</artifactId>
  <version>3.5.9.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.cardpay:java-sdk:3.5.9.1"
```

## Proxy usage

The SDK will automatically use a proxy if the `HTTPS_PROXY` or `HTTP_PROXY` environment variable is set.

If the `NO_PROXY` env variable is set, the SDK won't use the proxy for hosts from this variable. The format of
`NO_PROXY`: comma separated domain names (e.g. "cardpay.com,.example.com").
