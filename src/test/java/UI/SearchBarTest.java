package UI;

import driver.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import pages.*;
import pages.search.*;
import utils.*;

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
        Assertions.assertEquals("Найдите книгу среди 6001 тысяч наименований", name,"Name у строки поиска некорректный");
        logger.info("Имя у строки поиска корректное");
    }

    @Test
    public void searchShouldReturnPositiveResults(){
        searchBar.searchBarClick();
        searchBar.inputValueInSearchBar("Ijggth");
        searchBar.searchButtonClick();

        Assertions.assertFalse(searchBar.getPositiveSearchResult().isEmpty(),
                "Разделы должны отображаться при успешном поиске");

        Assertions.assertTrue(
                searchBar.getNegativeSearchResult().isEmpty(),
                "Сообщение 'Ничего не найдено' не должно отображаться"
        );

        logger.info("Поиск успешен, на странице отображаются разделы содержащие товар");


    }
    @Test
    public void searchShouldReturnNegativeResults() {
        searchBar.searchBarClick();
        searchBar.inputValueInSearchBar("Анигиляторная пушка");
        searchBar.searchButtonClick();

        Assertions.assertFalse(
                searchBar.getNegativeSearchResult().isEmpty(),
                "Сообщение 'Ничего не найдено' должно отображаться"
        );

        Assertions.assertTrue(
                searchBar.getPositiveSearchResult().isEmpty(),
                "Разделы не должны отображаться при пустом результате"
        );
        logger.info("Ничего не найдено, на странице не отображаются разделы содержащие товар отображается");
    }




    @AfterEach
    public void quit() {
        logger.info("Окончание теста, браузер закрыт");
        Driver.quit();
    }
}
