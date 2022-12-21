package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProductPage;
import pages.SignUpPage;

import java.time.Duration;

public class ProductTests {

    WebDriver driver;
   SignUpPage signUpPage;
   ProductPage productPage;
    String URL = "http://automationexercise.com";

    @BeforeClass

    public void setUp() {
        driver = new ChromeDriver();
        signUpPage=new SignUpPage(driver);
        productPage=new ProductPage(driver);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(signUpPage.getUrl(URL), "http://automationexercise.com");
        productPage.openProductPage();
        //softAssert.assertAll();
    }
    @Test
    public void checkProductMenu(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPage.GetProductTile(),"ALL PRODUCTS");
       productPage.AddAnyProduct("top");
        softAssert.assertEquals(productPage.GetProductInfo(),"SEARCHED PRODUCTS");
        softAssert.assertTrue(productPage.GetPageContent().toLowerCase().contains("top"),"Wrong Page");
       softAssert.assertAll();
    }

@Test
    public void checkFirstProductinthecart(){
    SoftAssert softAssert = new SoftAssert();
         productPage.AddProduct1();
         softAssert.assertEquals(productPage.viewFirstproduct(),"Blue Top");
    softAssert.assertEquals(productPage.viewFirstPrice(),(productPage.getPrice1()));
    softAssert.assertEquals(productPage.viewFirstQuantity(),"1");
    softAssert.assertEquals(productPage.viewTotalPrice1(),"Rs. 500");

             softAssert.assertAll();

}
@Test
    public void checkSecondProductinthecart(){
    SoftAssert softAssert = new SoftAssert();
    productPage.AddProduct2();
    softAssert.assertEquals(productPage.viewFirstproduct(),"Men Tshirt");
    softAssert.assertEquals(productPage.viewFirstPrice(),(productPage.getPrice2()));
    softAssert.assertEquals(productPage.viewFirstQuantity(),"1");
    softAssert.assertEquals(productPage.viewTotalPrice1(),"Rs. 400");
    softAssert.assertAll();

}



}

