package UI;

import driver.Driver;
import org.apache.logging.log4j.*;
import pages.HomePage;
import org.junit.jupiter.api.*;
import utils.*;

public class HomePageTest {

    private static final Logger logger = LoggerUtil.getlogger(HomePageTest.class);
    private HomePage homePage;

    @BeforeEach
    public void openHomePage() {
        System.out.println("BEFORE EACH START");
        logger.info("Начало подготовки теста");
        homePage = new HomePage();
        homePage.openHomePage();
        logger.info("Главня страница открыта");
    }


    @Test
    public void homePageShouldOpenWithCorrectUrl() {
        logger.info("Тест: homePageShouldOpenWithCorrectUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(homePage.getHomePageUrl(), actualUrl, "Некорректный URL главной страницы");
        logger.info("URL главной страницы корректный");
    }

    @Test
    public void  companyNameShouldBeVisibleOnHomePage(){
        logger.info("Тест: companyNameShouldBeVisibleOnHomePage");
        String expectedCompanyName = "Общество с ограниченной ответственностью «Абрис-Бел»";
        Assertions.assertEquals(expectedCompanyName, homePage.getCompanyName(), "Название компании на главной странице некорректное");
        logger.info("Название компании на главное странице корректное");
    }

    @Test
    public void loginButtonShouldBeDisplayed() {
        logger.info("Тест: loginButtonShouldBeDisplayed");
        Assertions.assertTrue(homePage.isLoginButtonDisplayed(), "Кнопка входа не отображается");
        logger.info("Кнопка входа отображается");
    }

    @Test
    public void loginButtonShouldBeEnable() {
        logger.info("Тест: loginButtonShouldBeEnabled");
        Assertions.assertDoesNotThrow(() -> {
            homePage.isLoginButtonEnable();
            logger.info("Кнопка входа активна");
        });
    }

    @Test
    public void searchBarShouldBeDisplayed() {
        logger.info("Тест: searchBarShouldBeDisplayed");
        Assertions.assertTrue(homePage.isSearchBarDisplayed(), "Строка поиска не отображается");
        logger.info("Строка поиска отображается");
    }

    @Test
    public void searchBarShouldBeEnabled() {
        logger.info("Тест: searchBarShouldBeEnabled");
        Assertions.assertDoesNotThrow(() -> {
            homePage.isSearchBarEnable();
        });
        logger.info("Строка поиска активна");
    }

    @AfterEach
    public void tearDown() {
        logger.info("Окончание теста");
        Driver.quit();
    }
}