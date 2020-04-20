package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

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
                get(PATH).
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
                get(PATH_WITH_ID).
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
                get(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
