package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class DeletePersonClient extends BaseAPI {

    public DeletePersonClient() {
        BaseAPI.baseConfig();
    }

    public ValidatableResponse deletePerson(int id) {
        return
            given().
                spec(spec).
                pathParam("id", id).
            when().
                delete(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK);
    }

    public ValidatableResponse deletePersonNotFound(int id) {
        return
            given().
                spec(spec).
                pathParam("id", id).
            when().
                delete(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}