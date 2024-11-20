package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {

    /**
     * Main method to execute browser automation tasks using Selenium WebDriver.
     *
     * @param args Command-line arguments (not used in this example).
     * @throws InterruptedException If the thread sleep is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of WebDriver (controls the Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook's homepage
        driver.get("https://www.facebook.com/");

        // Wait for 2 seconds to ensure the page fully loads
        Thread.sleep(2000);

        // Locate and click on the "English" language option
        WebElement englishButton = driver.findElement(By.partialLinkText("English"));
        englishButton.click();

        // Locate and click on the "Create new account" link
        driver.findElement(By.partialLinkText("Create new")).click();

        // Wait for 2 seconds to ensure the page fully loads
        Thread.sleep(2000);

        // Locate the dropdown menus for birth month, day, and year
        Select monthListBox = new Select(driver.findElement(By.name("birthday_month")));
        Select dayListBox = new Select(driver.findElement(By.name("birthday_day")));
        Select yearListBox = new Select(driver.findElement(By.name("birthday_year")));

        // Check if the day dropdown is a multi-select dropdown
        System.out.println("Day dropdown is multiple? " + dayListBox.isMultiple());

        // Select options from the dropdown menus
        dayListBox.selectByVisibleText("10"); // Select the 10th day
        monthListBox.selectByIndex(3);       // Select April (index starts at 0)
        yearListBox.selectByValue("2010");   // Select the year 2010

        // Wait for 2 seconds to observe the changes
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
