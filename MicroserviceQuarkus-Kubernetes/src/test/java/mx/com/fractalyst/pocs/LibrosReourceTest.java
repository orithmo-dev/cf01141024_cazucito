package mx.com.fractalyst.pocs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class LibrosReourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/libros")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

}