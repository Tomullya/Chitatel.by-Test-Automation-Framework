package by.chitatel.api;

import io.restassured.response.*;
import java.util.*;
import static io.restassured.RestAssured.given;

public class SearchApiService extends BaseApiService{
    private static final String ACCEPT_HTML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";

    public Response doSearch(String searchQuery) {
        if (cookies == null || csrfToken == null) {
            throw new IllegalStateException(
                    "Session is not initialized. Call init() first."
            );
        }

        response = given()
                .headers(getSearchHeaders())
                .cookies(cookies)
                .queryParam("query", searchQuery)
                .when()
                .post(BASE_URL + "/searchnew");

        return response;
    }

    private Map<String, String> getSearchHeaders() {
        Map<String, String> headers = new HashMap<>(getHeaders());
        headers.put("Accept", ACCEPT_HTML);
        return headers;
    }

}


