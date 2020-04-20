package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Person;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PostPersonClient extends BaseAPI {

    public PostPersonClient() {
        BaseAPI.baseConfig();
    }

    public ValidatableResponse postPerson(Person person) {
        return
            given().
                spec(spec).
                body(person).
            when().
                post("/people").
            then().
                statusCode(HttpStatus.SC_CREATED).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse postPersonBadRequest(Person person) {
        return
            given().
                spec(spec).
                body(person).
            when().
                post("/people").
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }
}
