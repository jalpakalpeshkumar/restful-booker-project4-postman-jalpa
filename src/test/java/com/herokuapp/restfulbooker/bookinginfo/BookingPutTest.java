package com.herokuapp.restfulbooker.bookinginfo;

import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingPutTest extends TestBase {

    @Test
    public void testUpdateBooking() {
        int bookingId = 1; // Use an existing booking ID

        String requestBody = "{\n" +
                "  \"firstname\": \"Jane\",\n" +
                "  \"lastname\": \"Doe\",\n" +
                "  \"totalprice\": 150,\n" +
                "  \"depositpaid\": false,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"2024-12-25\",\n" +
                "    \"checkout\": \"2024-12-31\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Lunch\"\n" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/booking/" + bookingId);

        // Validate response status code and details
        response.then()
                .statusCode(200)
                .body("firstname", equalTo("Jane"))
                .body("lastname", equalTo("Doe"))
                .body("totalprice", equalTo(150))
                .body("depositpaid", equalTo(false));
    }

}
