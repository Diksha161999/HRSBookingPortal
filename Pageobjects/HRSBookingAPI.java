package Pageobjects;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HRSBookingAPI {

    private static final String BASE_URL = "testurl";
    private static final String SEARCH_ENDPOINT = "/hotels/search";

    public static Response searchHotels(String location, String arrivalDate, String departureDate, boolean lowAvailability) {
        String requestBody = "{\n" +
                "  \"location\": \"" + location + "\",\n" +
                "  \"arrivalDate\": \"" + arrivalDate + "\",\n" +
                "  \"departureDate\": \"" + departureDate + "\",\n" +
                "  \"filter\": {\n" +
                "    \"lowAvailability\": " + lowAvailability + "\n" +
                "  }\n" +
                "}";

        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(SEARCH_ENDPOINT);
    }

}
