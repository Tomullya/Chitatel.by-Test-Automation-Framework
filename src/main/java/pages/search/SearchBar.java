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

    public void search(String value){
        WebElement input =Wait.waitUntilVisible(SearchLocator.SEARCH_BAR);
        input.clear();
        input.sendKeys(value);
        driver.findElement(SearchLocator.SEARCH_BUTTON).click();
    }

    /*public void clearButtonClick() {
        Wait.waitUntilClickable(SearchLocator.CLEAR_BUTTON).click();
    }*/

    public List<WebElement> getProductImages(){
        Wait.waitUntilVisible(SearchLocator.PRODUCT_IMAGE);
        return driver.findElements(SearchLocator.PRODUCT_IMAGE);
    }
    public boolean isNothingFoundMessageDisplayed(){
        return !driver.findElements(SearchLocator.NOTHING_FOUND_MESSAGE).isEmpty();
    }

    /*public List<WebElement> getPositiveSearchResult() {
        return driver.findElements(SearchLocator.SEARCH_POSITIVE_RESULT);
    }

    public List<WebElement> getNegativeSearchResult() {
        return driver.findElements(SearchLocator.NOTHING_FOUND_MESSAGE);
    }*/

    public String getSearchInputValue() {
        return driver.findElement(SearchLocator.SEARCH_BAR)
                .getAttribute("value");
    }



}
