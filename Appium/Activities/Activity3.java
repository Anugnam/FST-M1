package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.sec.android.app.popupcalculator")
                .setAppActivity(".Calculator")
                .noReset();
        //set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //initialize the android driver
        driver = new AndroidDriver(serverURL,caps);
    }
    @Test(priority = 1)
    public void addTest(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("14 Calculation result")).getText(),"14");
    }
    @Test(priority = 2)
    public void subTest(){
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("5 Calculation result")).getText(),"5");
    }
    @Test(priority = 3)
    public void mulTest(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("500 Calculation result")).getText(),"500");
    }
    @Test(priority = 4)
    public void divTest(){
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("0")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("25 Calculation result")).getText(),"25");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
