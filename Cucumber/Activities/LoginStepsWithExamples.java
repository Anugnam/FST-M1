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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepsWithExamples{
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void login(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium/login-form");
        Assertions.assertEquals("Login Form",driver.getTitle());

    }
    @When("User enters {string} and {string}")
    public void enterCredentialsFromExamples(String username, String password) {
        //find input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        //clear fields
        usernameField.clear();
        passwordField.clear();
        //find username field and enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void confirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);
        String message = driver.findElement(By.id("action-confirmation")).getText();
        if (message.contains("admin")) {
            Assertions.assertEquals("Welcome Back, admin", message);
        } else {
            Assertions.assertEquals("Invalid Credentials", message);
        }

    }
    @And("ClosetheBrowser")
    public void clsBrowser(){
        driver.quit();
    }


}
