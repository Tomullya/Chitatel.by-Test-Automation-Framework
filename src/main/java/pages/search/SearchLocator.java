package pages.search;

import org.openqa.selenium.*;

public class SearchLocator {
    public static final By SEARCH_BAR = By.id("input-search");
    public static final By SEARCH_BAR_NAME = By.xpath("//form[@id='search']//input[@name='query']");
    public static final By SEARCH_BUTTON = By.xpath("//form[@id='search']//span[contains(@class,'btn-search')]");
    public static final By CLEAR_BUTTON = By.xpath("//form[@id='search']//div[contains(@class,'clear-search')]");
    public static final By SEARCH_POSITIVE_RESULT = By.xpath("//div[contains(@class,'filters-title') and normalize-space(.)='Разделы']");
    public static final By SEARCH_NEGATIVE_RESULT = By.xpath("//h2[normalize-space(.)='Ничего не найдено.']");
}
