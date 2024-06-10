package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        //create driver object
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: "+ pageTitle);
        Thread.sleep(2000);
        String thirdHeaderName = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third Header name is: "+thirdHeaderName);
        Thread.sleep(2000);
        String fifthHeaderColor = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("Fifth Header Color is: "+fifthHeaderColor);
        Thread.sleep(2000);
        String violetClassName = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Classes for violet button: "+violetClassName);
        Thread.sleep(2000);
        String greyText = driver.findElement(By.xpath("//button[@class='ui grey button']")).getText();
        System.out.println("Grey button text is "+greyText);
        Thread.sleep(2000);
        driver.quit();
    }
}
