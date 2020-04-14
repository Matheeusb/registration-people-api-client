package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.Person;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PutPersonClient extends BaseAPI {

    public PutPersonClient() {
        BaseAPI.baseConfig();
    }

    public Person putPerson(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                put("/people/{id}").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().body().as(Person.class);
    }

    public ValidatableResponse putPersonBadRequest(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                put("/people/{id}").
            then().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    public ValidatableResponse putPersonNotFound(Person person) {
        return
            given().
                spec(spec).
                pathParam("id", person.getId()).
                body(person).
            when().
                put("/people/{id}").
            then().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

}
