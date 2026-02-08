package UI;

import driver.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import pages.*;
import utils.*;

public class LoginFormTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginFormTest.class);

    private HomePage homePage;
    private LoginForm loginForm;


    @BeforeEach
    public void LoginForm() {
        logger.info("начало подготовки теста");
        homePage = new HomePage().openHomePage();
        logger.info("Главная страница открыта");
        loginForm = homePage.openLoginForm();
        logger.info("Форма логина открыта");
        loginForm.clickEmailButton();
        logger.info("Вкладка логина по email открыта");
    }


    @Test
    public void emailInputShouldBeDisplayed() {
        logger.info("Проверка отображения поля для ввода Email");
        Assertions.assertTrue(loginForm.isEmailInputDisplayed(), "Поле вввода Email не отображается");
        logger.info("Поле вввода Email отображается");
    }

    @Test
    public void passwordInputShouldBeDisplayed() {
        logger.info("Проверка отображения поля для ввода Password");
        Assertions.assertTrue(loginForm.isPasswordInputDisplayed(), "Поле вввода Password не отображается");
        //logger.info("Поле ввода Password отображается");
    }

    @Test
    public void submitButtonShouldBeDisplayed() {
        logger.info("Проверка отображения кнопки Войти");
        Assertions.assertTrue(loginForm.isSubmitButtonDisplayed(), "Кнопка Войти не отображается");
        logger.info("Кнопка Войти  отображается");
    }

    @AfterEach
    public void tearDown() {
        logger.info("Окончание теста, браузер закрыт");
        Driver.quit();
    }
}
