package by.chitatel.ui.pages.login;

import by.chitatel.ui.driver.*;
import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import org.openqa.selenium.*;

public class LoginForm {
    private final WebDriver driver = Driver.getDriver();

    private final By EMAIL_BUTTON = By.xpath("//a[contains(@class,'_js-tab-btn') and normalize-space()='Email']");
    private final By EMAIL_INPUT = By.xpath("//input[@type='email' and @name='email']");
    private final By PASSWORD_INPUT = By.xpath("//input[@class='input__default' and @name='password']");
    private final By SUBMIT_BUTTON = By.xpath("//input[@id='send-login']");
    private final By CHECKBOX = By.xpath("//div[@class='input checkbox']");
    private final By PASSWORD_FORGET_LINK = By.xpath("//a[@href='https://chitatel.by/password/reset']");
    private final By LOGIN_ERROR = By.xpath("//div[@class='alert alert-danger']/ul/li");

    public void clickEmailButton() {
        Wait.waitUntilClickable(EMAIL_BUTTON).click();
    }

    public boolean isEmailInputDisplayed() {
        return Wait.waitUntilVisible(EMAIL_INPUT).isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return Wait.waitUntilVisible(PASSWORD_INPUT).isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        return Wait.waitUntilVisible(SUBMIT_BUTTON).isDisplayed();
    }

    public boolean isCheckboxDisplayed() {
        return Wait.waitUntilVisible(CHECKBOX).isDisplayed();
    }

    public boolean isPasswordForgetLinkDisplayed() {
        return Wait.waitUntilVisible(PASSWORD_FORGET_LINK).isDisplayed();
    }

    public void enterEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys("email");
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys("password");
    }

    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void login(String email, String password) {
        clickEmailButton();
        enterEmail(email);
        enterPassword(password);
        clickSubmitButton();
    }

    public String getLoginErrorText() {
        return Wait.waitUntilVisible(LOGIN_ERROR).getText();
    }

}


