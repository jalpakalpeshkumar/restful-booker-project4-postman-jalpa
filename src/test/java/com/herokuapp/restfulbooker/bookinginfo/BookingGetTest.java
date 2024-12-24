package com.herokuapp.restfulbooker.bookinginfo;

import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingGetTest extends TestBase {

    @Test
    public void testGetBookingById() {
        int bookingId = 1; // Use an existing booking ID

        Response response = given()
                .when()
                .get("/booking/" + bookingId);

        // Validate response status code and details
        response.then()
                .statusCode(200)
                .body("firstname", equalTo("John"))
                .body("lastname", equalTo("Doe"))
                .body("totalprice", equalTo(100));
    }

    // Test: GET /ping - Check API status
    @Test
    public void testPing() {
        Response response = given()
                .when()
                .get("/ping");

        // Validate response status code
        response.then()
                .statusCode(200)
                .body(equalTo("Created"));
    }
}
