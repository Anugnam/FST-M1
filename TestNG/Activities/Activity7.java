package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        //installing geckodriver
        WebDriverManager.firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/login-form");
        Reporter.log("Browser Opened");
    }
    @DataProvider(name = "Authentication")
    public static Object[][] credentials(){
        return new Object[][]{{"admin","password"}};
    }
    @Test(dataProvider = "Authentication")
    public void loginpage(String username, String password){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
    }
    @AfterClass
    public void tearDown(){
        Reporter.log("Browser closed");
        //close browser
        driver.quit();
    }
}
