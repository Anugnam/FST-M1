package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //installing geckodriver
        WebDriverManager.firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        Reporter.log("Browser Opened");
    }
    @Test
    public void titleTest(){
        Assert.assertEquals(driver.getTitle(),"Target Practice");
        Reporter.log("Target page loaded");
    }
    @Test
    public void buttonTest(){
       String buttonText = driver.findElement(By.xpath("//button[@class = 'ui black button']")).getText();
       Assert.assertEquals(buttonText,"Blue");
       Reporter.log("Incorrect button");
    }
    @Test(enabled = false)
    public void skip(){
        System.out.println("This shouldn't be printed");
    }
    @Test
    public void skipTestEx(){
        throw new SkipException("Skipping test case");
    }
    @AfterClass
    public void tearDown(){
        Reporter.log("Browser closed");
        //close browser
        driver.quit();
    }
}
