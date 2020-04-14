package clients;

import commons.BaseAPI;
import io.restassured.http.ContentType;
import models.Person;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetPersonClient extends BaseAPI {

    public GetPersonClient() {
        BaseAPI.baseConfig();
    }

    public List<Person> getPeople() {
        return
            given().
                spec(spec).
            when().
                get("/people").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().jsonPath().getList("", Person.class);
    }

    public Person getPerson(int id) {
        return
            given().
                spec(spec).
                pathParam("id", id).
            when().
                get("/people/{id}").
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().body().as(Person.class);
    }

    public void getPersonNotFound(int id) {
        given().
            spec(spec).
            pathParam("id", id).
        when().
            get("/people/{id}").
        then().
            statusCode(HttpStatus.SC_NOT_FOUND).
            contentType(ContentType.JSON);
    }
}
