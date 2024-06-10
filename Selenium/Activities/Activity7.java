package activities;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Page Title: "+driver.getTitle());
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropZoneOne = driver.findElement(By.id("droppable"));
        WebElement dropZoneTwo = driver.findElement(By.id("dropzone2"));
        builder.clickAndHold(football).moveToElement(dropZoneOne).release().build().perform();
        String confirmMessage1 = dropZoneOne.findElement(By.tagName("p")).getText();
        if(confirmMessage1.equals("Dropped!"))
            System.out.println("Ball dropped in zone 1");
        builder.dragAndDrop(football,dropZoneTwo).build().perform();
        String confirmMessage2 = dropZoneTwo.findElement(By.tagName("p")).getText();
        if(confirmMessage2.equals("Dropped!"))
            System.out.println("Ball dropped in zone 2");
        driver.quit();
    }
}
