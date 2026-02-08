package pages;

import driver.*;
import org.openqa.selenium.*;
import utils.*;

public class LoginForm {
    private WebDriver driver;

    private final By EMAIL_BUTTON = By.xpath("//a[contains(@class,'_js-tab-btn') and normalize-space()='Email']");
    private final By EMAIL_INPUT = By.xpath("//input[@type='email' and @name='email']");
    private final By PASSWORD_INPUT = By.xpath("//input[@class='input__default' and @name='password']");
    private final By SUBMIT_BUTTON = By.id("send-login");


    public LoginForm() {
        this.driver = Driver.getDriver();
    }

    public boolean isEmailButtonDisplayed(){
        return driver.findElement(EMAIL_BUTTON).isDisplayed();

    }
    public void clickEmailButton(){
        Wait.waitUntilClickable(EMAIL_BUTTON).click();
    }

    public boolean isEmailInputDisplayed() {
        return Wait.waitUntilVisible(EMAIL_INPUT).isDisplayed();
    }

    public void clickEmailInput() {
        driver.findElement(EMAIL_INPUT).click();
    }

    public void enterEmail() {
        driver.findElement(EMAIL_INPUT).sendKeys("test@test.com");
    }



    public boolean isPasswordInputDisplayed() {
        return Wait.waitUntilVisible(PASSWORD_INPUT).isDisplayed();
    }

    public void clickPasswordInput() {
        driver.findElement(PASSWORD_INPUT).click();
    }

    public void enterPassword() {
        driver.findElement(PASSWORD_INPUT).sendKeys("qwerty");
    }

    public boolean isSubmitButtonDisplayed() {
        return Wait.waitUntilVisible(SUBMIT_BUTTON).isDisplayed();
    }

    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

}
