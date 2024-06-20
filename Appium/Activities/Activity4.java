package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.samsung.android.contacts")
                .setAppActivity(".contactslist.PeopleActivity")
                .noReset();
        //set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //initialize the android driver
        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void addContact(){
        Dimension dimension = driver.manage().window().getSize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create contact"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id='com.samsung.android.contacts:id/topBackForHalfCameraIcon']/android.widget.ImageView")));
        //scroll to the end of the page
        Point start = new Point((int) (dimension.getWidth()*0.5) ,(int)(dimension.getHeight()*0.3));
        Point end = new Point((int)(dimension.getWidth()*0.5),(int)(dimension.getHeight()*0.5));
        doSwipe(driver,start,end,562);
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.contacts:id/accountSpinner"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='SIM card']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.contacts:id/simNameEdit"))).sendKeys("Aaditya Varma");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.samsung.android.contacts:id/titleText' and @text='Phone']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"))).sendKeys("999148292");
        driver.findElement(AppiumBy.id("com.samsung.android.contacts:id/smallLabel")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.contacts:id/communication_card")));
        String contactName = driver.findElement(AppiumBy.id("com.samsung.android.contacts:id/header")).getText();
        Assert.assertEquals("Aaditya Varma",contactName);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
