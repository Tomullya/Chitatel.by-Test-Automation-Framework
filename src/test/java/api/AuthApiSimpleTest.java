package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthApiSimpleTest {
    private static final String TITLE ="Книжный интернет-магазин в Минске с доставкой по Беларуси | Читатель.by";


    @Test
    void HomePageShouldBeOpenedInBrowser() {
        LoginApiService loginApiService = new LoginApiService();
        Response response = loginApiService.doGetRequest();
        int actualStatus =response.statusCode();
        String responseBody = response.asString();

        assertEquals(
                200, actualStatus, "Ожидалм статус код 200, но получили" +actualStatus
        );

        assertTrue(
                responseBody.contains(TITLE),
                "В ответе не найден title:" + TITLE
        );


    }
}
