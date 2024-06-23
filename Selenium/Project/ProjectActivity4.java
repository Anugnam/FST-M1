package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectActivity4 {
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
    public void addNew() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        action.moveToElement(PIM).click().build().perform();
        action.moveToElement(PIM).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee-information")));
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Project");
        driver.findElement(By.id("lastName")).sendKeys("Employee");
        driver.findElement(By.id("btnSave")).click();

      }
    @AfterClass
    public void tearDown(){
        //close the browser
        driver.quit();
    }
}
