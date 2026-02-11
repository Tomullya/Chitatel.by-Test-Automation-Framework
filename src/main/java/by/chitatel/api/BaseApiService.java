package by.chitatel.api;

import io.restassured.response.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class BaseApiService {
    protected static final String BASE_URL = "https://chitatel.by";
    protected static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
            + "AppleWebKit/537.36 (KHTML, like Gecko)"
            + "Chrome/121.0.0.0 Safari/537.36";
    protected static final String FORM_URLENCODED = "application/x-www-form-urlencoded";
    protected Map<String, String> cookies;
    protected String csrfToken;
    protected Response response;

    public void initSession(){
        response = given()
                .headers(getHeaders())
                .when()
                .get(BASE_URL);

        cookies = response.getCookies();
        csrfToken = response.htmlPath().getString("html.head.meta.find { it.@name == 'csrf-token' }.@content");
    }

    protected Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", USER_AGENT);
        return headers;
    }

    public Response getLastResponse() {
        return response;
    }
}
