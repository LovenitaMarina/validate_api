package assurityConsulting.assurityConsulting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateApi {

    private static final Logger logger = LoggerFactory.getLogger(ValidateApi.class);

    @Test
    public void validateResponseBodyTest() {
        try {
            // Specify base URI
            RestAssured.baseURI = "https://api.tmsandbox.co.nz";

            // Request object
            RequestSpecification httpRequest = RestAssured.given();

            // Response object
            Response response = httpRequest.get("/v1/Categories/6327/Details.json?catalogue=true");

            // Validate HTTP status code
            Assert.assertEquals("Expected HTTP status code 200", 200, response.getStatusCode());

            // Parse response JSON
            String name = response.jsonPath().getString("Name");
            boolean canRelist = response.jsonPath().getBoolean("CanRelist");
            String galleryDescription = response.jsonPath()
                    .getString("Promotions.find { it.Name == 'Gallery' }.Description");

            // Assertions
            Assert.assertEquals("Name does not match the expected value", "Carbon credits", name);
            Assert.assertTrue("CanRelist is not true", canRelist);
            Assert.assertTrue("Gallery description does not contain the expected text", galleryDescription.contains("Good position in category"));

            // Log results
            logger.info("Name: {}", name);
            logger.info("CanRelist: {}", canRelist);
            logger.info("Gallery Description: {}", galleryDescription);
        } catch (Exception e) {
            logger.error("Error occurred during test execution", e);
            Assert.fail("Test failed due to exception");
        }
    }
}