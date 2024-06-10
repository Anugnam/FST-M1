package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        //get firefox driver
        WebDriverManager.firefoxdriver().setup();
        //create driver object
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://training-support.net/");
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: "+ pageTitle);
        Thread.sleep(2000);
        driver.findElement(By.linkText("About Us")).click();
        String aboutTitle = driver.getTitle();
        System.out.println("About page title: " + aboutTitle);
        Thread.sleep(2000);
        driver.quit();
    }
}
