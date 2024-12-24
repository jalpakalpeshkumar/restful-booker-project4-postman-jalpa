package com.herokuapp.restfulbooker.bookinginfo;

import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingDeleteTest extends TestBase {

    @Test
    public void testDeleteBooking() {
        int bookingId = 1; // Use an existing booking ID

        Response response = given()
                .when()
                .delete("/booking/" + bookingId);

        // Validate response status code
        response.then()
                .statusCode(201);
    }

}
