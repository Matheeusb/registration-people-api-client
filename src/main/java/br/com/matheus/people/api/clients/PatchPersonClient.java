package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import br.com.matheus.people.api.models.Person;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PatchPersonClient extends BaseAPI {

    public PatchPersonClient(String environment) {
        BaseAPI.baseConfig(environment);
    }

    public ValidatableResponse patchPerson(Person person, String attribute) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(attribute).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse patchPersonBadRequest(int id, String requestBody) {
        return
            given().
                spec(spec).
                pathParam("id", id).
                body(requestBody).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    public ValidatableResponse patchPersonNotFound(int id, String requestBody) {
        return
            given().
                spec(spec).
                pathParam("id", id).
                body(requestBody).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}