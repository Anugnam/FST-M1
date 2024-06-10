package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity18 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Home page title: " + driver.getTitle());
        // Find the dropdown
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(selectElement);
        multiSelect.selectByVisibleText("Javascript");
        // Select 4th, 5th, and 6th index options
        for(int i = 4; i<=6 ; i++) {
            multiSelect.selectByIndex(i);
        }
        multiSelect.selectByValue("node");
        // Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
        // Deselect the 5th index option
        multiSelect.deselectByIndex(5);
        // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
        driver.quit();
    }
}
