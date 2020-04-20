package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Person;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetPersonClient extends BaseAPI {

    public GetPersonClient() {
        BaseAPI.baseConfig();
    }

    public ValidatableResponse getPeople() {
        return
            given().
                spec(spec).
            when().
                get("/people").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse getPerson(int id) {
        return
            given().
                spec(spec).
                pathParam("id", id).
            when().
                get("/people/{id}").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse getPersonNotFound(int id) {
        return
            given().
                spec(spec).
                pathParam("id", id).
            when().
                get("/people/{id}").
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
