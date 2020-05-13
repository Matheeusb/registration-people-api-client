package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class GetActuatorClient extends BaseAPI {

    public GetActuatorClient(String environment) {
        BaseAPI.baseConfig(environment);
    }

    public ValidatableResponse getActuatorHealth() {
        return
            given().
                spec(spec).
            when().
                get(PATH_ACTUATOR).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
}
