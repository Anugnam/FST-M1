package Activities;

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

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.samsung.android.messaging")
                .setAppActivity("com.android.mms.ui.ConversationComposer")
                .noReset();
        //set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //initialize the android driver
        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void messageApp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Compose new message"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("New conversation")));
        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to")).sendKeys("9703666599");
        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).sendKeys("Hello From Appium");
        driver.findElement(AppiumBy.accessibilityId("Send")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/title_template")));
        driver.findElement(AppiumBy.id("android:id/button2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.samsung.android.messaging:id/composer_bottom_panel")));
        String messageText = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.samsung.android.messaging:id/content_text_view'])[1]")).getText();
        Assert.assertEquals(messageText,"Hello From Appium");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
