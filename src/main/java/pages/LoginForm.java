package pages;

import driver.*;
import org.openqa.selenium.*;

public class LoginForm {
    private WebDriver driver;

    private final By EMAIL_BUTTON = By.xpath("//a[contains(@class,'_js-tab-btn') and normalize-space()='Email']");
    private final By EMAIL_INPUT = By.xpath("//input[@type='email' and @name='email']");
    private final By PASSWORD_INPUT = By.xpath("//input[@class='input__default' and @name='password_phone']");
    private final By SUBMIT_BUTTON = By.id("send-login-by-phone");


    public LoginForm() {
        this.driver = Driver.getDriver();
    }

    public boolean isEmailButtonDisplayed(){
        return driver.findElement(EMAIL_BUTTON).isDisplayed();

    }
    public void clickEmailButton(){
        driver.findElement(EMAIL_BUTTON).click();
    }

    public boolean isPhoneInputDisplayed() {
        return driver.findElement(EMAIL_INPUT).isDisplayed();
    }

    public void clickPhoneInput() {
        driver.findElement(EMAIL_INPUT).click();
    }

    public void enterPhone() {
        driver.findElement(EMAIL_INPUT).sendKeys("test@test.com");
    }


    public boolean isPasswordInputDisplayed() {
        return driver.findElement(PASSWORD_INPUT).isDisplayed();
    }

    public void clickPasswordInput() {
        driver.findElement(PASSWORD_INPUT).click();
    }

    public void enterPassword() {
        driver.findElement(PASSWORD_INPUT).sendKeys("qwerty");
    }

    public boolean isSubmitButtonDisplayed() {
        return driver.findElement(SUBMIT_BUTTON).isDisplayed();
    }

    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

}
