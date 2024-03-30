package TestCases;

import Pageobjects.HRSBookingAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRSBookingAPITest {

    @Test
    public void testFilterByLowAvailability() {
        Response response = HRSBookingAPI.searchHotels("Barcelona", "2024-06-21", "2024-06-28", true);

        // Verify response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200");

        // Verifying API response structure
        Assert.assertTrue(response.getBody().jsonPath().getBoolean("hasLowAvailability"));

        
    }

    @Test
    public void testNoLowAvailabilityHotels() {
        Response response = HRSBookingAPI.searchHotels("London", "2024-07-01", "2024-07-07", false);

        // Verify response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code: 200");

        // Verify the API response structure
        Assert.assertFalse(response.getBody().jsonPath().getBoolean("hasLowAvailability"));

        }

    
}
