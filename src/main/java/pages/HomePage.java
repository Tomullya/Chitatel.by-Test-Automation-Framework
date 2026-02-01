package pages;

import driver.*;
import org.openqa.selenium.*;

public class HomePage {
    private final String HOME_URL = "https://chitatel.by/";
    private final By LOGIN_BUTTON = By.xpath("//div[@class=\"name\" and text()=\"Вход\"]");

    private WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public void open() {
        driver.get(HOME_URL);
    }
    public String getHome_Url(){
        return HOME_URL;
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

}
