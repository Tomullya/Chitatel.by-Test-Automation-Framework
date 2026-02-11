package by.chitatel.api;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Авторизация")
@Feature("Открытие главной страницы")

public class GetHomePageApiTest {
    private static final String TITLE ="Книжный интернет-магазин в Минске с доставкой по Беларуси | Читатель.by";





    @Test
    @Story("Доступность главной страницы")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Главная страница открывается и возвращает статус 200")
    @Description("Проверка того, что главная страница chitatel.by доступна и содержит корректный title")

    void HomePageShouldBeOpenedInBrowser() {
        LoginApiService loginApiService = new LoginApiService();
        Response response = loginApiService.doGetRequest();
        int actualStatus =response.statusCode();
        String responseBody = response.asString();

        assertEquals(
                200, actualStatus, "Ожидаем статус код 200, но получили" +actualStatus
        );

        assertTrue(
                responseBody.contains(TITLE),
                "В ответе не найден title:" + TITLE
        );


    }
}
