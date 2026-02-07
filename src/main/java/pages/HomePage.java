package pages;

import driver.*;
import org.openqa.selenium.*;


public class HomePage {

    private final String HOME_URL = "https://chitatel.by/";

    private final By LOGIN_BUTTON = By.xpath("//div[@class=\"name\" and text()=\"Вход\"]");
    private final By SEARCH_BAR = By.xpath(" //input[@id=\"input-search\"]");
    private final By COMPANY_NAME = By.xpath("//div[contains(@class, 'f-name') and contains(text(),'Абрис-Бел')]");

    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();

    }

    public void openHomePage() {
        driver.get(HOME_URL);
    }

    public String getHomePageUrl() {
        return HOME_URL;
    }

    public String getCompanyName(){
        return driver.findElement(COMPANY_NAME).getText();
    }


    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void isLoginButtonEnable() {
        driver.findElement(LOGIN_BUTTON).click();
    }


    public boolean isSearchBarDisplayed() {
        return driver.findElement(SEARCH_BAR).isDisplayed();
    }

    public void isSearchBarEnable() {
        driver.findElement(SEARCH_BAR).click();
    }


}
