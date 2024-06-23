package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity5 {
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
    public void editProfile(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement lastName =  driver.findElement(By.id("personal_txtEmpLastName"));
        firstName.clear();
        lastName.clear();
        firstName.sendKeys("Anugna");
        lastName.sendKeys("M");
        driver.findElement(By.id("personal_optGender_2")).click();
        Select dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
        dropdown.selectByVisibleText("Indian");
        WebElement DOB = driver.findElement(By.id("personal_DOB"));
        DOB.clear();
        DOB.sendKeys("2000-03-10");
        driver.findElement(By.id("btnSave")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
