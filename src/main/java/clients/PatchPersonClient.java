package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Person;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PatchPersonClient extends BaseAPI {

    public PatchPersonClient() {
        BaseAPI.baseConfig();
    }

    public Person patchPerson(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch("/people/{id}").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().body().as(Person.class);
    }

    public ValidatableResponse patchPersonBadRequest(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch("/people/{id}").
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse patchPersonNotFound(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                patch("/people/{id}").
            then().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }
}