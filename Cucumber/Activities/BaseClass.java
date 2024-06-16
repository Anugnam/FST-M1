package StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    //creating an instance for firefox browser
    static WebDriver driver;
    static WebDriverWait wait;


}
