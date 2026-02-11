package by.chitatel.api;

import by.chitatel.utils.*;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("API")
@Feature("Home Page")

public class GetHomePageApiTest {
    private static final Logger logger = LoggerUtil.getlogger(GetHomePageApiTest.class);

    private static final String TITLE ="Книжный интернет-магазин в Минске с доставкой по Беларуси | Читатель.by";

    private BaseApiService baseApiService;

    @BeforeEach
    void setUp() {
        logger.info("Initializing BaseApiService before test");
        baseApiService = new BaseApiService();
    }





    @Test
    @Story("Home page availability")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Home page returns 200 status")
    @Description("Verify that the home page is accessible and contains correct title.")

    void HomePageShouldBeOpenedInBrowser() {
        logger.info("Sending GET request to home page");

        baseApiService.initSession();

        Response response = baseApiService.getLastResponse();

        logger.info("Response received with status code: {}", response.statusCode());

        int actualStatus =response.statusCode();
        String responseBody = response.asString();

        assertEquals(
                200, actualStatus, "Expected status code 200 but got" +actualStatus
        );

        logger.info("Validating page title in response body");

        assertTrue(
                responseBody.contains(TITLE),
                "Response body does not contain expected title: " + TITLE
        );

        logger.info("Home page test completed successfully, response body contains correct title ");


    }
}
