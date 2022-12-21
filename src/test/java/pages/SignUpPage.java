package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    String URL = "http://automationexercise.com";
    WebDriver driver;

    By Loginbtn = By.xpath("//a[@href='/login']");

    public SignUpPage(WebDriver webDriver) {

        this.driver= webDriver;
    }
    public String getUrl(String url) {

        return URL;
    }

       public void clickOnLogin (){
            driver.findElement(Loginbtn).click();

        }


    }





