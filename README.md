# quarkus-mailer-mjml Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Components

This module is using the following components:
- cdi
- [mailer](https://quarkus.io/guides/mailer-reference)
- [qute](https://quarkus.io/guides/qute)
- [resteasy](https://quarkus.io/guides/rest-json)
- resteasy-jackson
- smallrye-context-propagation
- smallrye-openapi
- [swagger-ui](https://quarkus.io/guides/openapi-swaggerui)
- vertx
- [mjml](https://mjml.io/) the email responsive framework
- [lombok](https://projectlombok.org/)


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Running [MailHog](https://github.com/mailhog/MailHog) email testing tool for developers
```shell script
cd src/main/dockercompose/
docker-compose up
```

Then you can access to the mailbox @ http://localhost:8025/

## Testing application

You can use swagger to send email via the rest api

go to http://localhost:8080/q/swagger-ui

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-mailer-mjml-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
