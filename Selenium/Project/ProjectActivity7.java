package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity7 {
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
    public void addQualification(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewQualifications/empNumber/1']")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        WebElement companyName = driver.findElement(By.id("experience_employer"));
        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
        companyName.clear();
        jobTitle.clear();
        companyName.sendKeys("IBM");
        jobTitle.sendKeys("Tester");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
