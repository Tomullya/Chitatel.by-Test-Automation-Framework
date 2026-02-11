package UI;

import driver.Driver;
import org.apache.logging.log4j.*;
import pages.home.HomePage;
import org.junit.jupiter.api.*;
import testData.*;
import utils.*;

public class HomePageTest {

    private static final Logger logger = LoggerUtil.getlogger(HomePageTest.class);
    private HomePage homePage;

    @BeforeEach
    public void openHomePage() {
        logger.info("Opening Home Page before test execution");
        homePage = new HomePage().openHomePage();
    }

    @Test
    public void homePageShouldOpenWithCorrectUrl() {
        logger.info("Test: Verifying Home Page URL");

        String actualUrl = homePage.getCurrentHomePageUrl();
        String expectedURl = homePage.getExpectedUrl();
        Assertions.assertEquals(expectedURl, actualUrl, "Home page is opened via incorrect URL");

        logger.info("Home Page is opened via correct URL : {}", actualUrl);
    }

    @Test
    public void homePageFooterContainsCompanyDetails() {
        logger.info("Test: Verifying Company Details");
        String expectedLegalName = "Общество с ограниченной ответственностью «Абрис-Бел»";
        String expectedUNP = "УНП 193527916";
        String tradeRegisterNumber = "№551190";

        String footerText = homePage.getFooterText();

        Assertions.assertAll("Verify footer legal information",
                () -> Assertions.assertTrue(footerText.contains(expectedLegalName),
                        "Legal name is incorrect"),
                () -> Assertions.assertTrue(footerText.contains(expectedUNP),
                        "UNP number is incorrect"),
                () -> Assertions.assertTrue(footerText.contains(tradeRegisterNumber),
                        "Trade register number is incorrect")
        );
        logger.info("HomePage footer contains correct legal entity details : {}", expectedLegalName + " , " + expectedUNP + " , " + tradeRegisterNumber);

    }

    @Test
    public void companyLogoShouldBeVisible() {
        logger.info("Test: Verifying logo visibility");

        Assertions.assertTrue((homePage.isLogoVisible()), "Company logo is not visible");

        logger.info("Company logo is displayed correctly");
    }

    @Test
    public void loginButtonShouldOpenLoginForm() {
        logger.info("Test: Verifying login button functionality");

        Assertions.assertTrue(homePage.isLoginButtonDisplayed(), "Login button is not visible");

        homePage.clickLoginButton();

        Assertions.assertTrue(homePage.isLoginPopUpWindowVisible(), "Login form did not appear after clicking login button");

        logger.info("Login button works correctly - login form is displayed");
    }

    @Test
    public void searchBarShouldBeVisibleAndClickable() {
        logger.info("Test: Search bar is enabled");

        String testInput = "Test input for SEARCH_BAR";

        Assertions.assertTrue(homePage.isSearchBarDisplayed(), "Search bar is not visible");

        homePage.clickSearchBar();
        homePage.typeInSearch("Test input for SEARCH_BAR");
        Assertions.assertEquals(testInput,homePage.getSearchValue(), "Search input does not accept text");

        logger.info("Search bar is enabled");
    }

    @AfterEach
    public void quit() {
        logger.info("Test finished. Closing browser.");
        Driver.quit();
    }

}