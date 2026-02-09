package api;

import io.restassured.response.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import testData.*;
import utils.*;


public class SearchApiTest {
    private static final Logger logger = LoggerUtil.getlogger(SearchApiTest.class);


    @Test
    public void testSearchWithQueryNegative() {

        String searchGoodInRU = TestDataGenerator.randomRuWord();

        System.out.println(searchGoodInRU);

        SearchApiService searchApiService = new SearchApiService();
        searchApiService.doGetRequest();
        Response response = searchApiService.doSearch(searchGoodInRU);


        logger.info("Статус код ответа: {}", response.getStatusCode());

        Assertions.assertEquals(200, response.getStatusCode(), "Статус код ответа не совпадает с ожидаемым");

        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains("Ничего не найдено"),
                "Искомый товар " + searchGoodInRU + " не был найден");

        logger.info("Искомый товар " + searchGoodInRU + "  был найден");
    }

    @Test
    public void testSearchWithQueryPositive() {

        String searchGoodInEn = TestDataGenerator.randomEnWord();

        System.out.println(searchGoodInEn);

        SearchApiService searchApiService = new SearchApiService();
        searchApiService.doGetRequest();
        Response response = searchApiService.doSearch(searchGoodInEn);


        logger.info("Статус код ответа: {}", response.getStatusCode());

        Assertions.assertEquals(200, response.getStatusCode(), "Статус код ответа не совпадает с ожидаемым");

        String responseBody = response.getBody().asString();
        Assertions.assertFalse(responseBody.contains("Ничего не найдено"),
                "Искомый товар " + searchGoodInEn + " не был найден");

        logger.info("Искомый товар " + searchGoodInEn + "  был найден");
    }


}
