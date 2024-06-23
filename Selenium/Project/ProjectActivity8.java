package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectActivity8 {
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
    public void applyLeave(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        dropdown.selectByVisibleText("DayOff");
        WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        fromDate.clear();
        fromDate.sendKeys("2024-08-05");
        toDate.clear();
        toDate.sendKeys("2024-08-08");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
//        WebElement dateFrom = driver.findElement(By.id("calFromDate"));
//        WebElement dateTo = driver.findElement(By.id("calToDate"));
//        dateFrom.clear();
//        dateFrom.sendKeys("2024-08-21");
//        dateTo.clear();
//        dateTo.sendKeys("2024-08-21");
//        driver.findElement(By.id("btnSearch")).click();
        String leavedates = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[1]")).getText();

        String leaveStatus = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]")).getText();
        System.out.println("Leave status is: "+leaveStatus);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
