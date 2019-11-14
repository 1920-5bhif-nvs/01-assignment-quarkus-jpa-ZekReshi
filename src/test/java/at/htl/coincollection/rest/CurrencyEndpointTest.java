package at.htl.coincollection.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CurrencyEndpointTest {

    @Test
    public void testCurrencyEndpointGetAll() {
        given()
          .when().get("/api/currencies")
          .then()
             .statusCode(200);
    }

}