# Registration of People - Client

The purpose of this project is to provide calls to the methods of the Registration of People API, to be used in automated testing projects.

## Language and frameworks

- Java 13
- Maven
- RestAssured
- Lombok

## Command line execution

This client will serve as a dependency on the test project, so for that it is necessary to clone the project and execute the following command:

```shell script
mvn clean install
```

## Dependency

To use the client as a dependency on an automated testing project, it is necessary to insert the following tag, in case the project is maven:

```xml
    <dependency>
        <groupId>br.com.matheus</groupId>
        <artifactId>registration-people-api-client</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```

## Links

- [Registration of People - API](https://github.com/Matheeusb/registration-people-api)
- [Registration of People - Test](https://github.com/Matheeusb/registration-people-api-test)
