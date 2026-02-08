package utils;

import driver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Wait {
    private static final int TIMEOUT_SECONDS = 10;

    public static WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(
                Driver.getDriver(),
                Duration.ofSeconds(TIMEOUT_SECONDS)
        );
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static WebElement waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(
                Driver.getDriver(),
                Duration.ofSeconds(TIMEOUT_SECONDS)
        );
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}
