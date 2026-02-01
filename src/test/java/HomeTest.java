import driver.Driver;
import pages.HomePage;
import org.junit.jupiter.api.*;

public class HomeTest {

    private HomePage homePage;

    @BeforeEach
    public void openHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void isLoginButtonEnabled() {
        homePage.clickLogin();
    }
    @Test
    public void homePageShouldOpenWithCorrectUrl(){
        String expectedUrl = homePage.getHome_Url();

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(actualUrl,expectedUrl);
    }

    @AfterEach
    public void tearDown() {
        //Driver.quit();
    }
}