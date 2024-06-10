package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //installing geckodriver
        WebDriverManager .firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net");
        Reporter.log("Browser Opened");
    }
    @Test
    public void homepageTest(){
        Assert.assertEquals(driver.getTitle(),"Training Support");
        Reporter.log("Home page loaded");
        driver.findElement(By.id("about-link")).click();
        Assert.assertEquals(driver.getTitle(),"About Training Support");
        Reporter.log("About Us page loaded");
    }

    @AfterClass
    public void tearDown(){
        Reporter.log("Browser closed");
        //close browser
        driver.quit();
    }
}
