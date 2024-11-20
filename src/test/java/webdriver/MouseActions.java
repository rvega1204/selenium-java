package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseActions {

    /**
     * Main method that demonstrates interacting with a web page using Selenium WebDriver.
     *
     * It opens a website, clicks a link, performs scrolling actions, interacts with a dropdown menu,
     * and clicks on specific links using the Actions class and JavascriptExecutor.
     *
     * @param args the command line arguments (not used in this example).
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of WebDriver (controls the Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://freecoursesbuzz.online");

        // Maximize the browser window for better visibility
        driver.manage().window().maximize();

        // Wait for the page to load completely
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the "Testing" link (ensure the link text is correct)
        WebElement testingLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Testing")));
        testingLink.click();

        // Create an instance of Actions class to perform advanced keyboard and mouse interactions
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the bottom of the page using JavaScript
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll again to ensure you're at the very bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Wait for a few seconds to ensure all content is loaded after scrolling
        Thread.sleep(2000);

        // Interact with a dropdown menu
        WebElement menuElem = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-menu3")));
        menuElem.click();

        // Wait for the dropdown items to be clickable
        WebElement dropdownItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown-item']")));
        action.moveToElement(dropdownItem).click().perform();

        // Click on the link to "Open Google"
        WebElement openGoogleLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open Google")));
        action.moveToElement(openGoogleLink).click().perform();

        // Wait for the menu to open or the new page to load
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}
