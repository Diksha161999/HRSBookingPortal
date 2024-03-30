package TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.HRSBookingPage;

public class HRSBookingTest {
    private WebDriver driver;
    private HRSBookingPage bookingPage;

    @BeforeMethod
    public void setUp() {
        // Set the path to chromedriver.exe based on your system
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        bookingPage = new HRSBookingPage(driver);
    }

    @Test
    public void searchHotelsWithLowAvailabilityInBarcelona() {
        // Open HRS website
        driver.get("https://www.hrs.com/");
        driver.manage().window().maximize();
        //Accept Cookies
        bookingPage.CookiePopUp();
        //Click on destination Textbox
        bookingPage.DestinationTextBoxClick();

        // Enter destination as Barcelona
        bookingPage.destinationInput("Barcelona");
        
        bookingPage.selectDestinationSuggestion();
        //Click Arrival Date
        bookingPage.ArrivalDate();
        //Click Arrow Button
        bookingPage.arrowbutton();

        // Select Arrival and Departure dates
        bookingPage.arrivalDateselectcalender();
        bookingPage.selectDepartureDate("20", "April", "2024");

        // Apply Low Availability Filter
        bookingPage.applyLowAvailabilityFilter();

        // Click on Search button
        bookingPage.clickSearchButton();

        // Check if search results are displayed
        Assert.assertTrue(bookingPage.areSearchResultsDisplayed(), "Search results are not displayed.");

        // Check if hotels with low availability are displayed
        Assert.assertTrue(bookingPage.areHotelsWithLowAvailabilityDisplayed(), "Hotels with low availability are not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
