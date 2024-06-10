package activities;

import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //open the page
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println("Main Page Title: "+ driver.getTitle());
        System.out.println("Handle of the page is: "+ driver.getWindowHandle());
        //Find the button to open a new tab and click it
        driver.findElement(By.id("launcher")).click();
        //print the names of teh handles
        System.out.println("Current tabs are: "+driver.getWindowHandles());
        //Wait for the new tab to open
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        //print page title and handle
        System.out.println("New Page Title: "+ driver.getTitle());
        System.out.println("Handle of the page is: "+ driver.getWindowHandle());
        //find the next button and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton"))).click();
        //print the names of teh handles
        System.out.println("Current tabs are: "+driver.getWindowHandles());
        //Wait for the new tab to open
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        //print page title and handle
        System.out.println("New Page Title: "+ driver.getTitle());
        System.out.println("Handle of the page is: "+ driver.getWindowHandle());
        //close browser
        driver.quit();
    }
}
