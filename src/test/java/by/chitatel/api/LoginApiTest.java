package by.chitatel.api;

import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import io.qameta.allure.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API")
@Feature("Авторизация")
public class LoginApiTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginApiTest.class);


    @Test
    @Story("Негативные сценарии логина")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Логин с пустыми email и паролем")
    @Description("Проверка ошибки при попытке логина с пустыми email и паролем.")

    public void testForLoginWithEmptyCredentials() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с пустыми email и паролем");
        loginApiService.doPostLogin("","");
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Вы не указали \"Email\"", loginApiService.getEmailErrorMessage(),"Ошибка не соответствует ожиадемой"),
                () -> assertEquals("Вы не указали \"Пароль\"", loginApiService.getEmailPasswordMessage(), "Ошибка не соответствует ожиадемой"));

        logger.info("Тест авторизации успешно завершен");
    }

    @Test
    @Story("Негативные сценарии логина")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Логин с пустым email")
    @Description("Проверка ошибки при логине с пустым email и заполненным паролем.")

    public void testForLoginWithEmptyEmail() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с пустым email, пароль заполнен");
        loginApiService.doPostLogin("", TestDataGenerator.randomPassword());
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Вы не указали \"Email\"", loginApiService.getEmailErrorMessage(),"Ошибка не соответствует ожиадемой"));


        logger.info("Тест авторизации успешно завершен");
    }

    @Test
    @Story("Негативные сценарии логина")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Логин с пустым паролем")
    @Description("Проверка ошибки при логине с заполненным email и пустым паролем.")

    public void testForLoginWithEmptyPassword() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с пустым паролем, email заполнен");
        loginApiService.doPostLogin(TestDataGenerator.randomEmail(),"");
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Вы не указали \"Пароль\"", loginApiService.getEmailPasswordMessage(), "Ошибка не соответствует ожиадемой"));


                logger.info("Тест авторизации успешно завершен");
    }

    @Test
    @Story("Негативные сценарии логина")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Логин с неверными учетными данными")
    @Description("Проверка ошибки при логине с неверным email и паролем.")

    public void testForLoginWithInvalidCredentials() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с неверными email и паролем");
        loginApiService.doPostLogin(TestDataGenerator.randomEmail(), TestDataGenerator.randomPassword());
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Неправильный e-mail или пароль!", loginApiService.getInvalidCredentialsErrorMessage(),"Ошибка не соответствует ожиадемой"));


        logger.info("Тест авторизации успешно завершен");
    }

}

