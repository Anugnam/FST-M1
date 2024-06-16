package StepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends BaseClass {
    @BeforeAll
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("the user is on the login page")
    public void loginpage(){
        driver.get("https://v1.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form",driver.getTitle());

    }
    @When("the user enters username and password")
    public void entercredentials(){
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("password");

    }
    @When("the user enters {string} and {string}")
    public void entercredentialsfrominputs(String username, String password) {
        //find input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        //clear fields
        usernameField.clear();
        passwordField.clear();
        //find username field and enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("clicks the login button")
    public void clickSubmit(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("get the confirmation text and verify")
    public void confirmMessage(){
        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assertions.assertEquals("Welcome Back, admin", message);
    }
    @Then("get the confirmation text and verify message is {string}")
    public void confirmMessageasinput(String expectedmessage){
        String message = driver.findElement(By.id("action-confirmation")).getText();
        Assertions.assertEquals(expectedmessage, message);
    }
    @AfterAll
    public static void closebrowser(){
        driver.quit();
    }


}
