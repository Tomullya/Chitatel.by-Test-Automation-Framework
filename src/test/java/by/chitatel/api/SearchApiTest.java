package by.chitatel.api;

import by.chitatel.ui.testData.*;
import by.chitatel.utils.*;
import io.qameta.allure.*;
import io.restassured.response.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;


@Epic("API")
@Feature("Search functionality")
public class SearchApiTest {
    private static final Logger logger = LoggerUtil.getlogger(SearchApiTest.class);

    private SearchApiService searchApiService;


    @BeforeEach
    void setUpForSearch() {

        searchApiService = new SearchApiService();
        searchApiService.initSession();
    }


    @Test
    @Story("Product search")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Search with non-existing product")
    @Description("Send search request with non-existing product name. Expect 'Nothing found' message.")
    public void testSearchWithQueryNegative() {
        String searchGoodInRU = TestDataGenerator.randomRuWord();
        Response response = searchApiService.doSearch(searchGoodInRU);

        logger.info("Response status code: {}", response.getStatusCode());

        Assertions.assertEquals(200, response.getStatusCode(), "Unexpected status code");

        String responseBody = response.getBody().asString();

        Assertions.assertTrue(responseBody.contains("Ничего не найдено"),
                "Expected 'Nothing found' message for query: " + searchGoodInRU);

        logger.info("The product  " + searchGoodInRU + "  was found");
    }

    @Test
    @Story("Product search")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search with existing product")
    @Description("Send search request with existing product name. Expect search results.")
    public void testSearchWithQueryPositive() {
        String searchGoodInEn = TestDataGenerator.randomEnWord();
        Response response = searchApiService.doSearch(searchGoodInEn);

        logger.info("Response status code: {}", response.getStatusCode());

        Assertions.assertEquals(200, response.getStatusCode(), "Unexpected status code");

        String responseBody = response.getBody().asString();
        Assertions.assertFalse(responseBody.contains("Ничего не найдено"),
                "Expected search results for: " + searchGoodInEn + " not found");

        logger.info("The product " + searchGoodInEn + " was found successfully");
    }


}
