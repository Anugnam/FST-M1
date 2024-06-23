package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectActivity9 {
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
    public void emergencyContacts(){
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//a[@href='/orangehrm/symfony/web/index.php/pim/viewEmergencyContacts/empNumber/1']")).click();
        List<WebElement> emgcontacts = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr"));
        System.out.println("Details of all the emergency contacts: ");
        for(WebElement cell : emgcontacts) {
            System.out.println(cell.getText());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
