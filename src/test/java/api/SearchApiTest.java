package api;

import UI.*;
import io.restassured.response.*;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;
import utils.*;



public class SearchApiTest {
    private static final Logger logger = LoggerUtil.getlogger(LoginFormTest.class);

    @Test
    public void testSearchWithQuery() {
        SearchApiService searchApiService = new SearchApiService();

        searchApiService.doGetRequest();
        Response response = searchApiService.doSearch("taratta");

        response.then().statusCode(200);

        logger.info("Статус код ответа: {}", response.getStatusCode());
        logger.info("Response body:\n{}", response.getBody().asString());


}
}
