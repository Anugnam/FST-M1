package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) {
        //create driver object
        WebDriver driver = new FirefoxDriver();
        //open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println("Main Page Title: "+ pageTitle);
        //find select webElement
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        //Select the second option using the visible text
        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Select the third option using the index
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Select the fourth option using the value
        dropdown.selectByValue("4");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //Get all the options and print them to the console
        System.out.println("All available options are: ");
        for (WebElement option: dropdown.getOptions()){
            System.out.println(option.getText());//since the object option is WebElement we use getText to get the option text
        }
        //close browser
        driver.quit();
    }
}
