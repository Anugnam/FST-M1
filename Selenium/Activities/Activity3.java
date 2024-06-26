package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        //create driver object
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/login-form");
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: "+ pageTitle);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);
        driver.quit();
    }
}
