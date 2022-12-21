package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInfo;
import pages.LoginPage;
import pages.SignUpPage;
import pages.Registerpage;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    SignUpPage signUpPage;
    Registerpage registerpage;
    LoginPage loginPage;
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
        loginPage=new LoginPage(driver);
        signUpPage.clickOnLogin();


    }

        @Test
                public void newUserValidation(){
            SoftAssert softAssert = new SoftAssert();
            registerpage.register("Esraa","Esraa@hotmail.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Assert.assertEquals(accountinfo.AccountTitle(),"ENTER ACCOUNT INFORMATION");
            accountinfo.setPersonalInformation("123",1,1,"1996");
            accountinfo.selectCheckbox();
            accountinfo.setAdressInformation("Esraa","Mabed","VOIS",
                    "NasrCity","Futurecity",3,
                    "canada","canada","012","0102030");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Assert.assertEquals(accountinfo.SuccessCreation(),"ACCOUNT CREATED!");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            accountinfo.Continue();
           Assert.assertTrue(accountinfo.userLogged().contains("Esraa"),"Wrong User");
            softAssert.assertAll();


        }
        @Test
           public void deleteAccount(){
               accountinfo.deleteAccount();
             Assert.assertEquals(accountinfo.deleteMessage(),"ACCOUNT DELETED!");
             accountinfo.Continue();
           }
           @Test
    public void inValidRegister(){
        registerpage.register("esraa","esraa@hotmail");
               Assert.assertEquals(loginPage.getErrormsg(),"Email Address already exist!",
                       "Email Address already exist!");
           }




    }

