package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: "+ pageTitle);
        //Find the button to open a CONFIRM alert and click it
        driver.findElement(By.id("confirm")).click();
        //switch to alert and print the text in alert
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Message in the alert is: "+confirmAlert.getText());
        //close alert
        confirmAlert.accept();
        //close browser
        driver.quit();
    }
}
