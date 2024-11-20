package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {

    /**
     * Demonstrates the usage of Selenium WebDriver locators on the Facebook login page.
     * This method navigates to Facebook, interacts with various elements using different locator strategies,
     * and then closes the browser.
     *
     * @param args Command line arguments (not used in this method)
     * @throws InterruptedException If the thread is interrupted during sleep operations
     */
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of WebDriver (browser controller)
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook's homepage
        driver.get("https://www.facebook.com/");

        // Wait for 3 seconds to ensure the page fully loads
        Thread.sleep(3000);

        // Locate the email input field and enter a fake email address
        driver.findElement(By.id("email")).sendKeys("fakemailer@gmail.com");

        // Locate the password input field and enter a fake password
        driver.findElement(By.name("pass")).sendKeys("asdf123456678");

        // Locate and click the login button
        driver.findElement(By.name("login")).click();

        // Click on a button (tag <button>, assuming it's interactable)
        driver.findElement(By.tagName("button")).click();

        // Click the "Forgot password?" link
        driver.findElement(By.linkText("Forgot password?")).click();

        // Locate an input field using CSS selector and enter the fake email again
        driver.findElement(By.cssSelector("._55r1 _6luy")).sendKeys("fakemailer@gmail.com");

        // Click a link containing "password?" in its text
        driver.findElement(By.partialLinkText("password?")).click();

        // Wait for 8 seconds to allow for any subsequent actions or page loads
        Thread.sleep(8000);

        // Close the browser and terminate the WebDriver session
        driver.quit();
    }
}
