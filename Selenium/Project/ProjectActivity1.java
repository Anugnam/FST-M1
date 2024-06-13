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

public class ProjectActivity1 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
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
    public void loginPage(){
        //get the title of the page
        String pageTitle = driver.getTitle();
        //match the title
        Assert.assertEquals(pageTitle,"OrangeHRM");
        Reporter.log("Title of the website matched exactly");
        String src = driver.findElement(By.tagName("img")).getAttribute("src");
        System.out.println("Image url is: "+ src);
    }
    @AfterClass
    public void tearDown(){
        //close the browser
        driver.quit();
    }
}
