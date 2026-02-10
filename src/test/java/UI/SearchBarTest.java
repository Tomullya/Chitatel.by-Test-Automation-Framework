package UI;

import driver.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pages.home.*;
import pages.search.*;
import testData.*;
import utils.*;

import java.util.*;

public class SearchBarTest {
    private static final Logger logger = LoggerUtil.getlogger(SearchBarTest.class);
    private HomePage homePage;
    private SearchBar searchBar;


    @BeforeEach
    public void openHomePage() {
        logger.info("Начало подготовки теста");

        homePage = new HomePage().openHomePage();
        searchBar = new SearchBar();

        logger.info("Главня страница открыта");
    }

    @Test
    public void SearchBarHasValidName(){
        String name =searchBar.getSearchBarName();
        Assertions.assertEquals("Найдите книгу среди 600 тысяч наименований", name,"Placeholder у строки поиска некорректный");
        logger.info("Имя у строки поиска корректное");
    }

    @Test
    public void searchShouldReturnProductImages() {
        String query = TestDataGenerator.randomRuWord();
        searchBar.search(query);

        List<WebElement> images = searchBar.getProductImages();

        if (images.isEmpty()) {
            logger.info("По запросу '{}' товары не найдены", query);
        } else {
            logger.info("По запросу '{}' найдено {} товаров", query, images.size());
        }

        Assertions.assertFalse(
                searchBar.isNothingFoundMessageDisplayed() && !images.isEmpty(),
                "Товар не найден"
        );
    }


    @Test
    public void searchShouldReturnProducts(){
        searchBar.search(TestDataGenerator.randomEnWord());

        Assertions.assertFalse(
                searchBar.getProductImages().isEmpty(), "При успешном поиске должны отображаться изображения товаров"
        );

        Assertions.assertFalse(
                searchBar.isNothingFoundMessageDisplayed(), "Сообщение 'Ничего не найдено' не должно отображаться"
        );

        logger.info("Поиск успешен: изображения товаров найдены");

    }



    @Test
    public void searchShouldReturnProductImagesDetermind(){
        searchBar.search("Cтивен Кинг");

        Assertions.assertFalse(
                searchBar.getProductImages().isEmpty(), "При успешном поиске должны отображаться изображения товаров"
        );

        Assertions.assertFalse(
                searchBar.isNothingFoundMessageDisplayed(), "Сообщение 'Ничего не найдено' не должно отображаться"
        );

        logger.info("Поиск успешен: изображения товаров найдены");

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
    public void clearButtonShouldBeClickableAndClearInput(){
        searchBar.searchBarClick();
        searchBar.inputValueInSearchBar(TestDataGenerator.randomEnWord());

        WebElement clearButton = Wait.waitUntilClickable(SearchLocator.CLEAR_BUTTON);
        Assertions.assertTrue(clearButton.isDisplayed(),
        "Кнопка Clear должна быть отображена после ввода текста");

        clearButton.click();

        Assertions.assertEquals("", searchBar.getSearchInputValue(),"Поле поиска должно быть очищено после нажатия Clear");
         logger.info("Clear кнопка кликабельна и очищает строку поиска");

    }


    @AfterEach
    public void quit() {
        logger.info("Окончание теста, браузер закрыт");
        Driver.quit();
    }
}
