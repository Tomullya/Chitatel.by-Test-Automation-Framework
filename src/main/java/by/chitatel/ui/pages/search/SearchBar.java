package by.chitatel.ui.pages.search;

import by.chitatel.ui.driver.*;
import by.chitatel.utils.*;
import org.openqa.selenium.*;

import java.util.*;

public class SearchBar {
    private final WebDriver driver = Driver.getDriver();

    private static final By SEARCH_BAR = By.xpath("//input[@id ='input-search']");
    private static final By SEARCH_BAR_PLACEHOLDER_NAME = By.xpath("//form[@id='search']//input[@name='query']");
    private static final By SEARCH_BUTTON = By.xpath("//div[@class='w-search-btn']");
    private static final By CLEAR_BUTTON = By.xpath("//div[@class='clear-search  dnone ']");
    private static final By NOTHING_FOUND_MESSAGE = By.xpath("//div[@class='w-search-result-item']/h2");
    private static final By PRODUCT_IMAGE = By.xpath("//img[contains(@class,'product-img')]");


    public String getSearchBarName() {
        return Wait.waitUntilVisible(SEARCH_BAR_PLACEHOLDER_NAME).getDomAttribute("placeholder");
    }


    public void inputValueInSearchBar(String value) {
        WebElement input = driver.findElement(SEARCH_BAR);
        input.clear();
        input.sendKeys(value);
    }

    public void searchButtonClick() {
        Wait.waitUntilClickable(SEARCH_BUTTON).click();
    }

    public void search(String value) {
        inputValueInSearchBar(value);
        searchButtonClick();
    }

    public void clearSearchFiled() {
        Wait.waitUntilClickable(CLEAR_BUTTON).click();
    }

    public List<WebElement> getProductImages() {
        return driver.findElements(PRODUCT_IMAGE);
    }

    public boolean isNothingFoundMessageDisplayed() {
        return !driver.findElements(NOTHING_FOUND_MESSAGE).isEmpty();
    }

    public String getSearchInputValue() {
        return driver.findElement(SEARCH_BAR)
                .getAttribute("value");
    }

}
