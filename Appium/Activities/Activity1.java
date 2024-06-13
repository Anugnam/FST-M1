package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
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

    @Test
    public void multiplytest(){
        //Find the number 7 and tap it
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();

        //Find the multiply symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();

        //Find the number 6 and tap it
        driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();

        //Find the equalto symbol and tap it
        driver.findElement(AppiumBy.accessibilityId("Equal")).click();

        //Assertions
        String resultId = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        Assert.assertEquals(resultId,"42");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
