package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import br.com.matheus.people.api.models.Person;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PatchPersonClient extends BaseAPI {

    public PatchPersonClient() {
        BaseAPI.baseConfig();
    }

    public ValidatableResponse patchPerson(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse patchPersonBadRequest(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    public ValidatableResponse patchPersonNotFound(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}