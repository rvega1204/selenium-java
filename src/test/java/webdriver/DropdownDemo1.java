package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropdownDemo1 {

    /**
     * Main method to demonstrate how to interact with elements using mouse hover and select options.
     *
     * @param args command-line arguments (not used in this program)
     * @throws InterruptedException if the thread is interrupted during sleep
     */
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of WebDriver (controls the Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Open the Amazon website
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000); // Wait for the page to load completely

        // Locate the language selector dropdown element by its ID
        WebElement languageSelector = driver.findElement(By.id("icp-nav-flyout"));

        // Create an instance of Actions class to perform advanced user gestures
        Actions actions = new Actions(driver);

        // Perform the mouse hover action over the language selector to reveal the dropdown
        actions.moveToElement(languageSelector).perform();

        // Wait for the hover effect to take place (e.g., showing the language options)
        Thread.sleep(2000);

        // Locate the "English" option in the dropdown and click on it
        WebElement dropdownItem = driver.findElement(By.partialLinkText("English"));
        dropdownItem.click();

        // Wait for the page to adjust after selecting a language (in this case, "English")
        Thread.sleep(2000);

        // Find the search category dropdown element by its ID
        Select listBox = new Select(driver.findElement(By.id("searchDropdownBox")));

        // Get all options from the dropdown and print the size
        List<WebElement> allItems = listBox.getOptions();
        System.out.println("Total items in the search category dropdown: " + allItems.size());

        // Iterate over all the dropdown items and print each one
        for (WebElement item : allItems) {
            System.out.println(item.getText());
        }

        // Wait for 2 seconds before closing the browser (just to observe the results)
        Thread.sleep(2000);

        // Close the browser after the operation
        driver.quit();
    }
}
