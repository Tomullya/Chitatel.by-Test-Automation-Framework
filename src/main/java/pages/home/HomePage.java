package pages.home;

import driver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pages.login.*;
import utils.*;
import utils.Wait;


public class HomePage {

    private final String HOME_URL = "https://chitatel.by/";

    //private final By LOGIN_BUTTON = By.xpath("//div[@class=\"name\" and text()=\"Вход\"]");
    private final By LOGIN_POP_UP_WINDOW = By.xpath("//div[@class='h-login']//a[@class='block__link login__link login_popup']//div[@class ='name']");
    private final By SEARCH_BAR = By.xpath("//input[@id=\"input-search\"]");
    private final By COMPANY_NAME = By.xpath(" //div[contains(@class, 'f-name') and contains(text(),'Абрис-Бел')]");
    private final By LOGIN_BUTTON2 = By.xpath("//div[@class='h-login']//a[@class='block__link login__link login_popup']//div[@class ='name']");

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
        return Wait.waitUntilVisible(LOGIN_BUTTON2).isDisplayed();
    }

   /* public boolean isLoginButtonEnabled() {
        return driver.findElement(LOGIN_BUTTON).isEnabled();
    } */


    public void clickLoginButton() {
        Wait.waitUntilClickable(LOGIN_BUTTON2).click();
    }

    public LoginForm openLoginForm(){
        clickLoginButton();
        return new LoginForm();
    }

    public boolean isLoginPopUpWindowVisible(){
        return Wait.waitUntilVisible(LOGIN_POP_UP_WINDOW).isDisplayed();
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
