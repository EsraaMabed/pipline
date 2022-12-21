package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountInfo;
import pages.LoginPage;
import pages.Registerpage;
import pages.SignUpPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    SignUpPage signUpPage;
    AccountInfo accountInfo;
    Registerpage registerpage;
    LoginPage loginpage;
    String URL = "http://automationexercise.com";


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        registerpage = new Registerpage(driver);
        accountInfo = new AccountInfo(driver);
        loginpage = new LoginPage(driver);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void LoginSuccessfully() {
        signUpPage.clickOnLogin();
        Assert.assertEquals(loginpage.setLoginTitle(), "Login to your account");
        loginpage.EmailandPassword("esraa@hotmail.com", "123");
        Assert.assertTrue(accountInfo.userLogged().contains("esraa"), "Wrong User");
               accountInfo.deleteAccount();
              Assert.assertEquals(accountInfo.deleteMessage(),"ACCOUNT DELETED!");
    }
    @Test
    public void UnsuccessfulLogin(){
        signUpPage.clickOnLogin();
        Assert.assertEquals(loginpage.setLoginTitle(), "Login to your account");
        loginpage.EmailandPassword("haidi@hamada.com", "00");
        Assert.assertEquals(loginpage.getErrormsg(),"Your email or password is incorrect!","Your email or password is incorrect!");

    }

    @Test
    public void LoggedOut() {
        signUpPage.clickOnLogin();
        Assert.assertEquals(loginpage.setLoginTitle(), "Login to your account");
        loginpage.EmailandPassword("esraa@hotmail.com", "123");
        Assert.assertTrue(accountInfo.userLogged().contains("esraa"), "Wrong User");
        loginpage.Logout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");


}
}