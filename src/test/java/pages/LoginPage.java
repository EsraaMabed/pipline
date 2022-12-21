package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By LoginTitle = By.xpath("//div[@class='login-form']//h2");
    By Validemail = By.xpath("//input[@data-qa='login-email']");
    By Validpassword = By.xpath("//input[@data-qa='login-password']");
    By Loginbutton = By.xpath("//button[@data-qa='login-button']");
    By Errormessage = By.xpath("//form[@method=\"POST\"]/p[1]");
By LogoutButton = By.xpath("//*[@href=\"/logout\"]");

    public LoginPage(WebDriver webDriver) {
        this.driver= webDriver;
    }
    public String setLoginTitle(){
        return driver.findElement(LoginTitle).getText();
    }
    public void EmailandPassword(String email, String password){
        driver.findElement(Validemail).sendKeys(email);
        driver.findElement(Validpassword).sendKeys(password);
        driver.findElement(Loginbutton).click();
    }
    public String getErrormsg(){
return driver.findElement(Errormessage).getText();
    }
    public void Logout(){
        driver.findElement(LogoutButton).click();
    }















}
