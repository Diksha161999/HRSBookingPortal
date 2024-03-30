package Pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HRSBookingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By destinationInput = By.xpath("//input[@id='DestinationSearchInput']");
    private By DestinationTextBoxClick = By.xpath("//span[@title='Location, hotel, region, address, post code']");
    private By CookiePopUp = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private By destinationSuggestion = By.xpath("(//li[@data-test='DestinationList_suggestionItem'])[3]");
    private By arrowbutton = By.xpath("//body/div[@id='__next']/main[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[3]");
    private By arrivalDateclick = By.xpath("//div[@class='DateRangeInputField_date__IAUhI']");
    private By arrivalDateselect = By.xpath("(//div[@class='Day_container__Rx8e0 Day_weekend__RdgHk Day_arrival__vw_55'])[2]");
    private By departureDateInput = By.xpath("//input[@data-testid='departure-date-input']");
    private By searchButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private By lowAvailabilityCheckbox = By.xpath("//input[@data-testid='low-availability-checkbox']");
    private By searchResults = By.xpath("//div[@data-testid='search-results']");
    private By hotelAvailability = By.xpath("//div[@data-testid='hotel-availability']");

    public HRSBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CookiePopUp() {
        WebElement cookiePopUp = wait.until(ExpectedConditions.elementToBeClickable(CookiePopUp));
        cookiePopUp.click();
    }
    public void arrivalDateselectcalender() {
    	WebElement arrivalDateselectcalender = wait.until(ExpectedConditions.elementToBeClickable(arrivalDateselect));
    	arrivalDateselectcalender.click();
    }
    public void DestinationTextBoxClick() {
    	WebElement destinationclick = wait.until(ExpectedConditions.elementToBeClickable(DestinationTextBoxClick));
    	destinationclick.click();
    }
    public void destinationInput() {
    	WebElement destinationInputvalue = wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
    	destinationInputvalue.click();
    }
    
    public void destinationInput(String destination) {
    	WebElement destinationInputField = wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
    	destinationInputField.sendKeys(destination);
    }
    
    public void arrowbutton() {
    	WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(arrowbutton));
    	suggestion.click();
    }
    
    

    public void selectDestinationSuggestion() {
        WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(destinationSuggestion));
        suggestion.click();
    }

    
    public void ArrivalDate() {
    	WebElement arrivalDateInputField = wait.until(ExpectedConditions.elementToBeClickable(arrivalDateclick));
    	arrivalDateInputField.click();
    	
    }
    

    public void selectDepartureDate(String day, String month, String year) {
        WebElement departureDateInputField = wait.until(ExpectedConditions.elementToBeClickable(departureDateInput));
        departureDateInputField.click();
        selectDate(day, month, year);
    }

    public void applyLowAvailabilityFilter() {
        WebElement lowAvailabilityCheckboxElement = wait.until(ExpectedConditions.elementToBeClickable(lowAvailabilityCheckbox));
        lowAvailabilityCheckboxElement.click();
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButtonElement.click();
    }

    public boolean areSearchResultsDisplayed() {
        return driver.findElement(searchResults).isDisplayed();
    }

    public boolean areHotelsWithLowAvailabilityDisplayed() {
        return !driver.findElements(hotelAvailability).isEmpty();
    }

    private void selectDate(String day, String month, String year) {
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='js-calendar-container']")));
        String displayedMonthYear = calendar.findElement(By.xpath("//span[@class='js-calendar-headline']")).getText();
        while (!displayedMonthYear.equals(month + " " + year)) {
            WebElement nextButton = calendar.findElement(By.xpath("//button[@aria-label='Next']"));
            nextButton.click();
            displayedMonthYear = calendar.findElement(By.xpath("//span[@class='js-calendar-headline']")).getText();
        }
        WebElement selectedDay = calendar.findElement(By.xpath("//td[@aria-label='" + day + " " + month + " " + year + "']"));
        selectedDay.click();
    }
}


