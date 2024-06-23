package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void activityList() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView[@resource-id='com.google.android.apps.tasks:id/tasks_refresh_empty_scrollable']/android.widget.LinearLayout/android.widget.FrameLayout")));
//        driver.findElement(AppiumBy.accessibilityId("New list")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        String taskOne = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete Activity with Google Tasks']")).getText();
        Assert.assertEquals(taskOne, "Complete Activity with Google Tasks");
        String taskTwo = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete Activity with Google Keep']")).getText();
        Assert.assertEquals(taskTwo, "Complete Activity with Google Keep");
        String taskThree = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and @text='Complete the second Activity Google Keep']")).getText();
        Assert.assertEquals(taskThree, "Complete the second Activity Google Keep");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
