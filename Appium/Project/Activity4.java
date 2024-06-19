package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Activities.ActionsBase.doSwipe;

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver  =new AndroidDriver(serverURL,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium");

    }

    @Test
    public void webAppTest() throws InterruptedException {
        //get the width of the phone
        Dimension dimension = driver.manage().window().getSize();
        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        //scroll to the end of the page
        Point start = new Point((int) (dimension.getWidth()*0.5) ,(int)(dimension.getHeight()*0.8));
        Point end = new Point((int)(dimension.getWidth()*0.5),(int)(dimension.getHeight()*0.6));
        doSwipe(driver,start,end,85);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.EditText")));
        WebElement taskInput = driver.findElement(AppiumBy.className("android.widget.EditText"));
        WebElement addTaskBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        taskInput.sendKeys("Add tasks to list");
        addTaskBtn.click();
        Thread.sleep(2000);
        taskInput.sendKeys("Get number of tasks");
        addTaskBtn.click();
        Thread.sleep(2000);
        taskInput.sendKeys("Clear the list");
        addTaskBtn.click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
