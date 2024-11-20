package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods {

    /**
     * Main method to demonstrate performing a Google search with Selenium WebDriver.
     *
     * @param args command-line arguments (not used in this program)
     * @throws InterruptedException if the thread is interrupted during sleep
     */
    public static void main(String[] args) throws Exception {
        // Create an instance of WebDriver (controls the Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Open the Google website
        driver.get("https://www.google.com/");
        Thread.sleep(2000); // Wait for the page to load completely

        // Create an instance of Actions class to perform advanced keyboard and mouse interactions
        Actions action = new Actions(driver);

        // Locate the search box element by its 'name' attribute
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type the search query "selenium webdriver" into the search box
        searchBox.sendKeys("selenium webdriver");

        // Use the arrow down key to navigate through the autocomplete suggestions
        action.sendKeys(Keys.ARROW_DOWN); // First arrow down
        action.sendKeys(Keys.ARROW_DOWN); // Second arrow down
        action.sendKeys(Keys.ARROW_DOWN); // Third arrow down

        // Wait for a moment to simulate user interaction before submitting the search
        Thread.sleep(2000);

        // Press the 'Enter' key to submit the search
        action.sendKeys(Keys.ENTER).perform();

        // Pause execution for 2 seconds to simulate user interaction (optional)
        Thread.sleep(2000);

        // Close the browser after the test (not included in the original code, but often good practice)
        driver.quit();
    }
}
