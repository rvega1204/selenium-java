package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandleMethod {

    /**
     * A demonstration of Selenium WebDriver to navigate Gmail's homepage,
     * interact with various links, and handle multiple browser windows.
     */
    public static void main(String[] args) throws Throwable {
        // Create an instance of WebDriver (controls the Chrome browser)
        WebDriver driver = new ChromeDriver();

        // Navigate to Gmail's homepage
        driver.get("https://www.gmail.com/");

        // Wait for 2 seconds to ensure the page fully loads
        Thread.sleep(2000);

        // Capture the current window handle (parent window) for reference
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window ID: " + parentWindow);

        // Click on the "Help" link
        driver.findElement(By.linkText("Help")).click();

        // Click on the "Terms" link
        driver.findElement(By.linkText("Terms")).click();

        // Click on the "Privacy" link
        driver.findElement(By.linkText("Privacy")).click();

        // Get all window handles (parent and newly opened windows)
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All window IDs: " + allWindows);

        // Close the current browser window
        driver.close();
    }
}
