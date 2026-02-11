package by.chitatel.api;

import io.restassured.response.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class LoginApiService {
    private static final String BASE_URL = "https://chitatel.by";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
            + "AppleWebKit/537.36 (KHTML, like Gecko)"
            + "Chrome/121.0.0.0 Safari/537.36";
    private static final String FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final String ACCEPT_HTML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    private Map<String, String> cookies;
    private String csrfToken;
    private Response response;


    public Response doGetRequest() {
        response = given()
                .headers(getHeaders())
                .when()
                .get(BASE_URL);

        cookies = response.getCookies();
        csrfToken = response.htmlPath().
                getString("html.head.meta.find { it.@name == 'csrf-token' }.@content");

        return response;
    }

    public void printResponse() {
        response.then().log().all();
    }

    public Response doPostLogin(String email, String password) {
        if (cookies == null || csrfToken == null) {
            throw new IllegalStateException(
                    "Сессия не инициализирована сделай doGetRequest первым"
            );
        }
        String body =
                    "email=" + email +
                        "&password=" + password +
                        "&remember_me=1" +
                        "&_token=" + csrfToken;

        response = given()
                .headers(getHeaders())
                .header("Content-type", FORM_URLENCODED)
                .header("Origin", BASE_URL)
                .header("Referer", BASE_URL + "/login")
                .cookies(cookies)
                .body(body)
                .when()
                .post(BASE_URL + "/login");
        return response;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", USER_AGENT);
        headers.put("Accept", ACCEPT_HTML);
        return headers;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getEmailErrorMessage() {
        return response.body().jsonPath().getString("errors.email[0]");
    }

    public String getEmailPasswordMessage() {
        return response.body().jsonPath().getString("errors.password[0]");
    }

    public String getInvalidCredentialsErrorMessage(){
        return response.body().jsonPath().getString("errors.nouser");
    }

}


