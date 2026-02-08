package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginApiService {

    private static final String TITLE = "Книжный интернет-магазин в Минске с доставкой по Беларуси | Читатель.by";
    private final String BASE_URL = "https://chitatel.by";
    private Map<String, String> headers;
    private Response response;

    public void doGetRequest() {
         response = given()
                        .headers(headers)
                        .when()
                        .get(BASE_URL);
    }

    public void printResponse() {
        response.then()
                .log().all();
    }
}


