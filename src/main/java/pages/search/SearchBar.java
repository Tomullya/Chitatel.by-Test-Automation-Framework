package pages.search;

import driver.*;
import org.openqa.selenium.*;
import utils.*;

import java.util.*;

public class SearchBar {

    private WebDriver driver;


    public SearchBar() {
        this.driver = Driver.getDriver();
    }

    public String getSearchBarName() {
        return driver.findElement(SearchLocator.SEARCH_BAR_NAME).getDomAttribute("placeholder");
    }

    public void searchBarClick() {
        Wait.waitUntilVisible(SearchLocator.SEARCH_BAR).click();
    }

    public void inputValueInSearchBar(String search) {
        WebElement input = driver.findElement(SearchLocator.SEARCH_BAR);
        input.clear();
        input.sendKeys(search);
    }

    public void searchButtonClick() {
        driver.findElement(SearchLocator.SEARCH_BUTTON).click();
    }

    /*public void clearButtonClick() {
        Wait.waitUntilClickable(SearchLocator.CLEAR_BUTTON).click();
    }*/

    public List<WebElement> getPositiveSearchResult() {
        return driver.findElements(SearchLocator.SEARCH_POSITIVE_RESULT);
    }

    public List<WebElement> getNegativeSearchResult() {
        return driver.findElements(SearchLocator.SEARCH_NEGATIVE_RESULT);
    }
    public String getSearchInputValue() {
        return driver.findElement(SearchLocator.SEARCH_BAR)
                .getAttribute("value");
    }



}
