package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class AuthApiSimpleTest {
    private static final String TITLE ="Книжный интернет-магазин в Минске с доставкой по Беларуси | Читатель.by";
    private static final String BASE_URL = "https://chitatel.by";
    private Map<String, String> headers;



    @Test
    void openHomePageInBrowser() {

        Response response =
                given()
                        .baseUri("https://chitatel.by")
                        .header("User-Agent",
                                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                                        "Chrome/121.0.0.0 Safari/537.36")
                        .header("Accept",
                                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        //.header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                        .log().all()
                        .when()
                        .get("/");

        response.then()
                .log().all()
                .statusCode(200)
                .body(containsString(TITLE));
    }
}