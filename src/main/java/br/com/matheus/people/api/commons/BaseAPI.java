package br.com.matheus.people.api.commons;

import br.com.matheus.people.api.configurations.Environment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseAPI {

    public static RequestSpecification spec;
    public static final String PATH = "/people";
    public static final String PATH_WITH_ID = "/people/{id}";
    public static final String PATH_ACTUATOR = "/actuator/health";

    public static void baseConfig(String environment) {
        baseURI = Environment.getBaseURI(environment);
        port = Environment.getPort(environment);
        spec = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .build();

        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
