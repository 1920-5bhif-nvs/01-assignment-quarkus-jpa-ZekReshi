package at.htl.coincollection.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SourceEndpointTest {

    @Test
    public void testSourcesEndpointGetAll() {
        given()
          .when().get("/api/sources")
          .then()
             .statusCode(200);
    }

}