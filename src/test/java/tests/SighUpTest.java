package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInfo;
import pages.SignUpPage;
import pages.Registerpage;

import java.time.Duration;

public class SighUpTest {
    WebDriver driver;
    SignUpPage signUpPage;
    Registerpage registerpage;

    AccountInfo accountinfo;
    String URL = "http://automationexercise.com";


    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        signUpPage = new SignUpPage(driver);
        registerpage = new Registerpage(driver);
        accountinfo = new AccountInfo(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.getUrl(URL), "http://automationexercise.com");
        softAssert.assertAll();


    }

    @Test
    public void checkVisibiltyOfHomepage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signUpPage.getUrl(URL), "http://automationexercise.com");
        softAssert.assertAll();

    }

    @Test
    public void checkNewUserVisiblity() {
        SoftAssert softAssert = new SoftAssert();
        signUpPage.clickOnLogin();
        softAssert.assertTrue(registerpage.newUserTitle().contains("New User Signup!"), "New User Signup!");
        softAssert.assertAll();
    }

    @Test
    public void LoginValidation() {
        signUpPage.clickOnLogin();
        registerpage.register("EsraaMabed12","Esraa@gmail.com");
        Assert.assertTrue(accountinfo.AccountTitle().contains("ENTER ACCOUNT"), "ENTER ACCOUNT INFORMATION");
    }

}



