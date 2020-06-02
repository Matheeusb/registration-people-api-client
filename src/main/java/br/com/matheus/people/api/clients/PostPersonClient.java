package br.com.matheus.people.api.clients;

import br.com.matheus.people.api.commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import br.com.matheus.people.api.models.Person;
import org.apache.http.HttpStatus;

import static br.com.matheus.people.api.commons.PathConstant.*;
import static io.restassured.RestAssured.given;

public class PostPersonClient extends BaseAPI {

    public PostPersonClient(String environment) {
        BaseAPI.baseConfig(environment);
    }

    public ValidatableResponse postPerson(Person person) {
        return
            given().
                spec(spec).
                body(person).
            when().
                post(PATH).
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
                post(PATH).
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }
}
