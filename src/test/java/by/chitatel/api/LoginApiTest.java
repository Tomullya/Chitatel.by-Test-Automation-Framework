package by.chitatel.api;

import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import io.qameta.allure.*;
import io.restassured.response.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API")
@Feature("Authorization")
public class LoginApiTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginApiTest.class);
    private LoginApiService loginApiService;

    @BeforeEach
    public void setUpConnection() {
        logger.info("Initializing API session before test");
        loginApiService = new LoginApiService();
        loginApiService.initSession();
    }

    @Test
    @Story("Negative login scenarios")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with empty email and password")
    @Description("Verify error messages when both email and password are empty.")

    public void testForLoginWithEmptyCredentials() {
        logger.info("Testing login with empty email and password");

        Response response = loginApiService.doPostLogin("", "");
        response.then().log().all();


        assertAll("Login validation",
                () -> assertEquals(400, loginApiService.getStatusCode(), "Unexpected status code"),
                () -> assertEquals("Вы не указали \"Email\"", loginApiService.getEmailErrorMessage(), "Unexpected error message"),
                () -> assertEquals("Вы не указали \"Пароль\"", loginApiService.getEmailPasswordMessage(), "Unexpected error message\""));

        logger.info("Test completed successfully");
    }

    @Test
    @Story("Negative login scenarios")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with empty email")
    @Description("Verify error message when email is empty.")

    public void testForLoginWithEmptyEmail() {

        logger.info("Testing login with empty email");

        Response response = loginApiService
                .doPostLogin("", TestDataGenerator.randomPassword());

        response.then().log().all();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(), "Unexpected status code"),
                () -> assertEquals("Вы не указали \"Email\"", loginApiService.getEmailErrorMessage(), "Unexpected error message"));

        logger.info("Test completed successfully");
    }

    @Test
    @Story("Negative login scenarios")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with empty password")
    @Description("Verify error message when password is empty.")

    public void testForLoginWithEmptyPassword() {
        logger.info("Testing login with empty password");

        Response response = loginApiService.doPostLogin(TestDataGenerator.randomEmail(), "");
        response.then().log().all();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(), "Unexpected status code"),
                () -> assertEquals("Вы не указали \"Пароль\"", loginApiService.getEmailPasswordMessage(), "Unexpected error message"));

        logger.info("Test completed successfully");
    }

    @Test
    @Story("Negative login scenarios")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with invalid credentials")
    @Description("Verify error message when email and password are incorrect.")

    public void testForLoginWithInvalidCredentials() {
        logger.info("Testing login with invalid credentials");

        Response response = loginApiService
                .doPostLogin(TestDataGenerator.randomEmail(),
                        TestDataGenerator.randomPassword());

        response.then().log().all();

        assertAll("Login",
                () -> assertEquals(200, loginApiService.getStatusCode(), "Unexpected status code"),
                () -> assertEquals("Неправильный e-mail или пароль!", loginApiService.getInvalidCredentialsErrorMessage(), "Unexpected error message"));

        logger.info("Test completed successfully");
    }

}

