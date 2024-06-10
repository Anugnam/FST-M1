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

public class Activity5 {
    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        //installing geckodriver
        WebDriverManager.firefoxdriver().setup();
        //initializing firefox driver
        driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        Reporter.log("Browser Opened");
    }
    @Test (groups = {"HeaderTests","ButtonTests"})
    public void homepageTest(){
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }
    @Test (dependsOnMethods = {"homepageTest"}, groups = {"HeaderTests"})
    public void headerTest1(){
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Third header");
    }
    @Test(dependsOnMethods = {"homepageTest"}, groups = {"HeaderTests"})
    public void headerTest2(){
        Assert.assertEquals(driver.findElement(By.tagName("h5")).getCssValue("color"),"rgb(33, 186, 69)");
    }
    @Test(dependsOnMethods = {"homepageTest"}, groups = {"ButtonTests"})
    public void buttonTest1(){
        Assert.assertEquals(driver.findElement(By.xpath("//button[@class = 'ui olive button']")).getText(),"Olive");
    }
    @Test(dependsOnMethods = {"homepageTest"}, groups = {"ButtonTests"})
    public void buttonTest2(){
        Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Brown']")).getCssValue("color"),"rgb(255, 255, 255)");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        Reporter.log("Browser closed");
        //close browser
        driver.quit();
    }
}
