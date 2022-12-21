package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {
    String URL = "http://automationexercise.com";
    WebDriver driver;
    By Newuser = By.xpath("//div[@class='signup-form']//h2");
    By Name = By.xpath("//input[@data-qa='signup-name']");
    By Email = By.xpath("//input[@data-qa='signup-email']");
    By Signupbutton = By.xpath("//button[@data-qa='signup-button']");

    public Registerpage(WebDriver webDriver) {

        this.driver = webDriver;
    }

    public String newUserTitle() {
        return driver.findElement(Newuser).getText();

    }

    public void register(String name, String email) {
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Signupbutton).click();
    }


}


