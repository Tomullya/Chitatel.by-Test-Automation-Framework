package pages.home;

import driver.*;
import org.openqa.selenium.*;
import pages.login.*;


public class HomePage {

    private final String HOME_URL = "https://chitatel.by/";

    private final By LOGIN_BUTTON = By.xpath("//div[@class=\"name\" and text()=\"Вход\"]");
    private final By SEARCH_BAR = By.xpath("//input[@id=\"input-search\"]");
    private final By COMPANY_NAME = By.xpath(" //div[contains(@class, 'f-name') and contains(text(),'Абрис-Бел')]");

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

    public String getCompanyName() {
        return driver.findElement(COMPANY_NAME).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(LOGIN_BUTTON).isEnabled();
    }


    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public LoginForm openLoginForm(){
        clickLoginButton();
        return new LoginForm();
    }


    public boolean isSearchBarDisplayed() {
        return driver.findElement(SEARCH_BAR).isDisplayed();
    }

    public boolean isSearchBarEnabled() {
        return driver.findElement(SEARCH_BAR).isEnabled();
    }

    public void clickSearchBar() {
        driver.findElement(SEARCH_BAR).click();
    }


}
