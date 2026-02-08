package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthApiFullLoginTest {

    private static final String BASE_URL = "https://chitatel.by";

    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/121.0.0.0 Safari/537.36";

    @Test
    void loginWithEmptyCredentials_shouldReturn422() {

        // ---------- STEP 1: GET / (инициализация сессии) ----------
        Response getResponse =
                given()
                        .baseUri(BASE_URL)
                        .header("User-Agent", USER_AGENT)
                        .header("Accept",
                                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .header("Accept-Language",
                                "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                        .when()
                        .get("/");

        getResponse.then()
                .statusCode(200);

        // ---------- извлекаем cookies и CSRF ----------
        Map<String, String> cookies = getResponse.getCookies();

        String csrfToken =
                getResponse.htmlPath()
                        .getString("**.find { it.@name == 'csrf-token' }.@content");

        // ---------- STEP 2: POST /login ----------
        String body =
                "email=&password=&remember_me=1&_token=" + csrfToken;

        Response postResponse =
                given()
                        .baseUri(BASE_URL)
                        .header("User-Agent", USER_AGENT)
                        .header("Accept",
                                "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .header("Accept-Language",
                                "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .header("Origin", BASE_URL)
                        .header("Referer", BASE_URL + "/login")
                        .cookies(cookies)
                        .body(body)
                        .when()
                        .post("/login");

        // ---------- ASSERT ----------
        postResponse.then()
                .log().all()
                .statusCode(200);
    }
}