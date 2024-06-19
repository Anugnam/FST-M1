package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {
    AndroidDriver driver;
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
    }
    @Test
    public void addContact(){
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
        
    }
}
