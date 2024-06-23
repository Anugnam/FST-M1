package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.google.common.base.Predicates.equalTo;

public class ProjectActivity6 {
    WebDriver driver = new FirefoxDriver();
    Actions action = new Actions(driver);
    @BeforeClass()
    public void setUp() {
        //open the page
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test
    public void menuOption(){
        WebElement directory = driver.findElement(By.id("menu_directory_viewDirectory"));
        directory.isDisplayed();
        if (directory.isEnabled()){
            directory.click();
            directory.click();
        }
        String headerName = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(headerName,"Search Directory");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
