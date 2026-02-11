package by.chitatel.ui.pages.home;

import by.chitatel.ui.driver.*;
import by.chitatel.ui.pages.login.*;
import by.chitatel.ui.pages.search.*;
import org.openqa.selenium.*;
import by.chitatel.utils.Wait;


public class HomePage {

    private final String HOME_URL = "https://chitatel.by/";
    private final By LOGIN_BUTTON = By.xpath("//div[@class='h-login']//a[@class='block__link login__link login_popup']//div[@class ='name']");
    private final By LOGIN_POP_UP_WINDOW = By.xpath("//div[@class='h-login']//a[@class='block__link login__link login_popup']//div[@class ='name']");
    private final By SEARCH_BAR = By.xpath("//input[@id='input-search']");
    private final By FOOTER_BLOCK = By.xpath("//div[@class='col-footer col-lg-4  col-sm-6 col-12']/div[@class='f-block']");
    private final By LOGO = By.xpath("//div[@class='h-logo  ']");



    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public HomePage openHomePage() {
        driver.get(HOME_URL);
        return this;
    }

    public String getCurrentHomePageUrl() {
        return driver.getCurrentUrl();
    }

    public String getExpectedUrl() {
        return HOME_URL;
    }

    public String getFooterText() {
        return driver.findElement(FOOTER_BLOCK).getText();
    }

    public boolean isLogoVisible() {
        return Wait.waitUntilVisible(LOGO).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return Wait.waitUntilVisible(LOGIN_BUTTON).isDisplayed();
    }

    public void clickLoginButton() {
        Wait.waitUntilClickable(LOGIN_BUTTON).click();
    }

    public LoginForm openLoginForm() {
        clickLoginButton();
        return new LoginForm();
    }

    public boolean isLoginPopUpWindowVisible() {
        return Wait.waitUntilVisible(LOGIN_POP_UP_WINDOW).isDisplayed();
    }

    public boolean isSearchBarDisplayed() {
        return Wait.waitUntilVisible(SEARCH_BAR).isDisplayed();
    }

    public SearchBar getSearchBar() {
        return new SearchBar();
    }

    public void clickSearchBar() {
        Wait.waitUntilClickable(SEARCH_BAR).click();
    }

    public void typeInSearch(String text) {
        driver.findElement(SEARCH_BAR).sendKeys(text);
    }

    public String getSearchValue() {
        return driver.findElement(SEARCH_BAR).getAttribute("value");
    }

}
