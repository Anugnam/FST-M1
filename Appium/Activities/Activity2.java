package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
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
    }
    @Test
    public void homePage(){
        driver.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")));
        String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println("Title of the page is: "+pageTitle);
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));
        String newpageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("Heading of new page is: "+newpageTitle);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
