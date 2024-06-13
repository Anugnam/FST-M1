package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity3 {
    WebDriver driver;
    @BeforeClass()
    public void setUp() {
        //installing geckodriver
        WebDriverManager.firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("Browser Opened");
    }
    @Test
    public void loginWithCredentials(){
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Assert.assertEquals(driver.findElement(By.id("welcome")).getText(),"Welcome Tajdar");
        Reporter.log("Home Page opened");
    }
    @AfterClass
    public void tearDown(){
        //close the browser
        driver.quit();
    }
}
