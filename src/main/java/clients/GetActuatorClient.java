package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class GetActuatorClient extends BaseAPI {

    public GetActuatorClient() {
        BaseAPI.baseConfig();
    }

    public ValidatableResponse getActuatorHealth() {
        return
            given().
                spec(spec).
            when().
                get("/actuator/health").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
}
