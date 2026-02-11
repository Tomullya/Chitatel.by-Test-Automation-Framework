package by.chitatel.ui;

import by.chitatel.ui.driver.*;
import by.chitatel.ui.pages.home.*;
import by.chitatel.ui.pages.search.*;
import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import java.util.*;

public class SearchBarTest {
    private static final Logger logger = LoggerUtil.getlogger(SearchBarTest.class);

    private HomePage homePage;
    private SearchBar searchBar;


    @BeforeEach
    public void setUpHomePage() {
        logger.info("Opening home page");

        homePage = new HomePage().openHomePage();
        searchBar = homePage.getSearchBar();


        logger.info("Home page opened successfully");
    }

    @Test
    public void searchBarShouldHaveCorrectPlaceholder() {
        logger.info("Test: Verifying search input placeholder");

        String expectedPlaceholder = "Найдите книгу среди 600 тысяч наименований";
        String actualPlaceholder = searchBar.getSearchBarName();
        Assertions.assertEquals(expectedPlaceholder, actualPlaceholder, "Search input placeholder is incorrect");

        logger.info("Search input placeholder is correct");
    }

    @Test
    public void positiveSearchResultShouldReturnProductImages() {
        logger.info("Test: Verifying search -positive case ");
        String validSearchInput = "Cтивен кинг";

        logger.info("Performing search with valid searchInputValue: {}", validSearchInput);
        searchBar.search(validSearchInput);

        List<WebElement> images = searchBar.getProductImages();

        Assertions.assertFalse(
                images.isEmpty(),
                "Products should be displayed for valid search input"
        );

        Assertions.assertFalse(
                searchBar.isNothingFoundMessageDisplayed(),
                "'Nothing found' message should not be displayed"
        );

        logger.info("Positive search test passed successfully");
    }

    @Test
    public void negativeSearchShouldShowNothingFoundMessage() {
        logger.info("Test: Verifying search - negative case ");

        String invalidSearchInput = "zzzxxyyqqq123456";

        logger.info("Performing search with invalid value: {}", invalidSearchInput);

        searchBar.search(invalidSearchInput);

        Assertions.assertTrue(
                searchBar.isNothingFoundMessageDisplayed(),
                "'Nothing found' message should be displayed"
        );

        Assertions.assertTrue(
                searchBar.getProductImages().isEmpty(),
                "Products should not be displayed for invalid search"
        );

        logger.info("Negative search test passed successfully, nothing was found");
    }


    @Test
    public void searchShouldReturnNothingFoundMessage() {
        searchBar.search(TestDataGenerator.randomEnWord());

        Assertions.assertTrue(
                searchBar.getProductImages().isEmpty(),
                "Изображения товаров не должны отображаться"
        );

        Assertions.assertTrue(
                searchBar.isNothingFoundMessageDisplayed(),
                "Сообщение 'Ничего не найдено' должно отображаться"
        );
    }

    @Test
    public void clearButtonShouldClearSearchInput() {
        logger.info("Test: Verifying clear search input functionality");

        String value = "Стивен Кинг";
        logger.info("Entering value into search input: {}", value);
        searchBar.inputValueInSearchBar(value);
        Assertions.assertFalse(
                searchBar.getSearchInputValue().isEmpty(),
                "Search input should contain text before clearing"
        );

        logger.info("Clicking clear button");
        searchBar.clearSearchFiled();
        Assertions.assertEquals(
                "",
                searchBar.getSearchInputValue(),
                "Search input should be empty after clicking clear button"
        );

        logger.info("Clear search input test passed successfully");
    }


    @AfterEach
    public void quit() {
        logger.info("Окончание теста, браузер закрыт");
        Driver.quit();
    }
}
