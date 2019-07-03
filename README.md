# Cardpay Java SDK

You can sign up for a Cardpay account at https://cardpay.com.

## Getting Started

Please follow the [installation](#installation) instruction and visit []().
https://github.com/oastashev/cardpay-java/tree/master/src/test/java/com/cardpay/sdk/uat

## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.cardpay</groupId>
  <artifactId>java-sdk</artifactId>
  <version>1.4.4</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.cardpay:java-sdk:1.4.4"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/java-sdk-1.4.4.jar`

