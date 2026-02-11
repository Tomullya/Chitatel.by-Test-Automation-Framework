package by.chitatel.utils;

import by.chitatel.ui.driver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class Wait {
    private static final int DEFAULT_WAITING_TIME = 10;

    public static WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(
                Driver.getDriver(),
                Duration.ofSeconds(DEFAULT_WAITING_TIME)
        );
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static WebElement waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(
                Driver.getDriver(),
                Duration.ofSeconds(DEFAULT_WAITING_TIME)
        );
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}
