package by.chitatel.ui;

import by.chitatel.ui.driver.*;
import by.chitatel.ui.pages.home.*;
import by.chitatel.ui.pages.login.*;
import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

public class LoginFormTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginFormTest.class);

    private HomePage homePage;
    private LoginForm loginForm;


    @BeforeEach
    public void setUpLoginForm() {
        logger.info("Opening home page");

        homePage = new HomePage().openHomePage();

        logger.info("Opening login form");
        loginForm = homePage.openLoginForm();

        logger.info("Opening login by email tab");
        loginForm.clickEmailButton();
    }

    @Test
    public void emailInputFieldShouldBeDisplayed() {
        logger.info("Test: Verifying email input fiels is displayed");
        Assertions.assertTrue(loginForm.isEmailInputDisplayed(), "mail input isn't displayed");

        logger.info("Email input is displayed");
    }

    @Test
    public void passwordInputFieldShouldBeDisplayed() {
        logger.info("Test: Verifying password input is displayed");
        Assertions.assertTrue(loginForm.isPasswordInputDisplayed(), "Password input isn't displayed");

        logger.info("Password input is displayed");
    }

    @Test
    public void submitButtonShouldBeDisplayed() {
        logger.info("Test: Verifying submit button is displayed");
        Assertions.assertTrue(loginForm.isSubmitButtonDisplayed(), "Submit button isn't displayed");

        logger.info("Submit button is displayed");
    }

    @Test
    public void checkboxShouldBeDisplayed() {
        logger.info("Test: Verifying checkbox is displayed");
        Assertions.assertTrue(loginForm.isCheckboxDisplayed(), "Checkbox isn't displayed");

        logger.info("Checkbox is displayed");
    }

    @Test
    public void forgetPasswordLinkShouldBeDisplayed() {
        logger.info("Test: Verifying forget password link is displayed");
        Assertions.assertTrue(loginForm.isCheckboxDisplayed(), "Forget password link isn't displayed");

        logger.info("Forget password link is displayed");
    }

    @Test
    public void loginFormShouldWorkWithInvalidCredentials() {
        logger.info("Verifying login form works with invalid credentials");
        loginForm.login(TestDataGenerator.randomEmail(), TestDataGenerator.randomPassword());

        String actualErrorMessage = loginForm.getLoginErrorText();
        Assertions.assertEquals("Неправильный e-mail или пароль!", actualErrorMessage, "Unexpected 'Error' message is displayed");

        logger.info("'Error' message is displayed correctly");
    }

    @AfterEach
    public void quit() {
        logger.info("Test finished. Closing browser.");
        Driver.quit();
    }

}
