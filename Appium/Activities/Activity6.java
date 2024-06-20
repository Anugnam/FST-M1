package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();
        //set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //initialize the android driver
        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void imageCount(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageCount = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before Count: "+imageCount.size());
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollTextIntoView(\"jenny\")"));
        imageCount = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After count "+imageCount.size());
        Assert.assertEquals(imageCount.size(),5);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
