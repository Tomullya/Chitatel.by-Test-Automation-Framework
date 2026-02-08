package api;

import UI.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import utils.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthApiFullLoginTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginFormTest.class);

    @Test
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
    public void testForLoginWithEmptyEmail() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с пустым email, пароль заполнен");
        loginApiService.doPostLogin("","qwerty");
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Вы не указали \"Email1\"", loginApiService.getEmailErrorMessage(),"Ошибка не соответствует ожиадемой"));


        logger.info("Тест авторизации успешно завершен");
    }

    @Test
    public void testForLoginWithEmptyPassword() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с пустым паролем, email заполнен");
        loginApiService.doPostLogin("test@test.com","");
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Вы не указали \"Пароль\"", loginApiService.getEmailPasswordMessage(), "Ошибка не соответствует ожиадемой"));


                logger.info("Тест авторизации успешно завершен");
    }

    @Test
    public void testForLoginWithInvalidCredentials() {
        LoginApiService loginApiService = new LoginApiService();
        loginApiService.doGetRequest();
        logger.info("Проверка логина с неверными email и паролем");
        loginApiService.doPostLogin("test@test.com","qwerty");
        loginApiService.printResponse();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(),"Статус код не соответсвует ожидаемому"),
                () -> assertEquals("Неправильный e-mail или пароль!", loginApiService.getInvalidCredentialsErrorMessage(),"Ошибка не соответствует ожиадемой"));


        logger.info("Тест авторизации успешно завершен");
    }

}

