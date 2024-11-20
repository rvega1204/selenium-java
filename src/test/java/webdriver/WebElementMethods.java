package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

    /**
     * Main method to execute browser automation tasks using Selenium WebDriver.
     *
     * @param args Command-line arguments (not used in this example).
     * @throws InterruptedException If the thread sleep is interrupted.
     */
    public  static  void main(String[] args) throws InterruptedException {
        // Create a WebDriver instance to control the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to Google's homepage
        driver.get("https://www.google.com/");

        // Locate the search box using its name attribute
        WebElement searchBox = driver.findElement(By.name("q"));

        // Locate the search button (not used in this example)
        WebElement searchButton = driver.findElement(By.name("btnK"));

        // Enter a query into the search box
        searchBox.sendKeys("selenium webdriver");

        // Pause execution for 2 seconds to simulate user interaction
        Thread.sleep(2000);

        // Clear the search box
        searchBox.clear();

        // Locate the first result element using an XPath selector
        WebElement firstResult = driver.findElement(By.xpath("//div[@class='uU7dJb']"));

        // Retrieve the text content of the first result element
        String elementText = firstResult.getText();
        System.out.println("Element text: " + elementText);

        // Retrieve the 'autocomplete' attribute of the search box
        String autoComplete = searchBox.getAttribute("autocomplete");
        System.out.println("Autocomplete value: " + autoComplete);

        // Check and print if the search box is displayed, enabled, and selected
        System.out.println("Search box is displayed? " + searchBox.isDisplayed());
        System.out.println("Search box is enabled? " + searchBox.isEnabled());
        System.out.println("Search box is selected? " + searchBox.isSelected());

        // Close the browser and terminate the WebDriver session
        driver.quit();
    }
}
