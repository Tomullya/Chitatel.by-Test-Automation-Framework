package by.chitatel.api;

import io.restassured.response.*;

import static io.restassured.RestAssured.given;

public class LoginApiService extends BaseApiService {
    public Response doPostLogin(String email, String password) {
        if (cookies == null || csrfToken == null) {
            throw new IllegalStateException(
                    "Session not initialized. Call initSession() first."
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

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getEmailErrorMessage() {
        return response.body().jsonPath().getString("errors.email[0]");
    }

    public String getEmailPasswordMessage() {
        return response.body().jsonPath().getString("errors.password[0]");
    }

    public String getInvalidCredentialsErrorMessage() {
        return response.body().jsonPath().getString("errors.nouser");
    }

}


