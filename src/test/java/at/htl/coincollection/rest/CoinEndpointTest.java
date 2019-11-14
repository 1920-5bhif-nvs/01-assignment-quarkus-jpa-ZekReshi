package at.htl.coincollection.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CoinEndpointTest {

    @Test
    public void testCoinEndpointGetAll() {
        given()
          .when().get("/api/coins")
          .then()
             .statusCode(200);
    }

    @Test
    public void testCoinEndpointGetById() {
        given()
                .when().get("/api/coins/1")
                .then()
                .statusCode(200);
    }

}