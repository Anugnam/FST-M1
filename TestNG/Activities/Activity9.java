package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //installing geckodriver
        WebDriverManager.firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Browser Opened");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlert() {
        //Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
        //Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert |");
        //Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText);
        Assert.assertEquals("This is a JavaScript Alert!", alertText);
        simpleAlert.accept();
        Reporter.log("Alert closed");
        Reporter.log("Test case ended |");
    }

    @Test(priority = 1)
    public void confirmAlert() {
        Reporter.log("confirmAlert() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Alert opened |");
        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert |");
        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);
        confirmAlert.accept();
        Reporter.log("Alert closed |");
        Reporter.log("Test case ended |");
    }

    @Test(priority = 2)
    public void promptAlert() {
        Reporter.log("promptAlert() started |");
        //Click the button to open a simple alert
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");

        //Switch to alert window
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched to alert |");

        //Get text in the alert box and print it
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |");
        Assert.assertEquals("This is a JavaScript Prompt!", alertText);
        promptAlert.accept();
        Reporter.log("Alert closed |");
        Reporter.log("Test case ended |");
    }
    @AfterClass
    public void tearDown(){
        Reporter.log("Browser closed");
        //close browser
        driver.quit();
    }
}
