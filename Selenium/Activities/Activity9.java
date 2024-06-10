package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

 public class   Activity9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        //create driver object
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        //open the page
        driver.get("https://v1.training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        //find the click the Change content button
        driver.findElement(By.className("violet")).click();
        //wait for h1 element, then get text and print it
        String header1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
        System.out.println("Message on the page is: "+header1);
        //wait for h3 element to say "I'm late", then get the text and print
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        String header2 = driver.findElement(By.tagName("h3")).getText();
        System.out.println("New message on the page is: "+header2);
        //close browser
        driver.quit();
    }
}
