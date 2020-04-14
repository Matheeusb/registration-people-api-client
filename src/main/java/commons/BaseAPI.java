package commons;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseAPI {

    public static RequestSpecification spec;

    public static void baseConfig() {
        baseURI = "http://localhost";
        port = 8080;
        spec = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .build();

        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
