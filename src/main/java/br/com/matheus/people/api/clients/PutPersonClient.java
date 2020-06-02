package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import br.com.matheus.people.api.models.Person;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static br.com.matheus.people.api.commons.PathConstant.*;
import static io.restassured.RestAssured.given;

public class PutPersonClient extends BaseAPI {

    public PutPersonClient(String environment) {
        BaseAPI.baseConfig(environment);
    }

    public ValidatableResponse putPerson(Person person) {
        return
            given().
                spec(BaseAPI.spec).
                pathParam(PATH_PARAM_ID, person.getId()).
                body(person).
            when().
                put(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse putPersonBadRequest(Person person) {
        return
            given().
                spec(spec).
                pathParam(PATH_PARAM_ID, person.getId()).
                body(person).
            when().
                put(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse putPersonNotFound(Person person) {
        return
            given().
                spec(spec).
                pathParam(PATH_PARAM_ID, person.getId()).
                body(person).
            when().
                put(PATH_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
