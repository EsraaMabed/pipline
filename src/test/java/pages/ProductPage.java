package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ProductPage {
    By ProductButton = By.xpath("//*[@href=\"/products\"]");
    By AllProductTitle= By.xpath("//*[@class=\"title text-center\"]");
    By SearchPlaceholder = By.xpath("//input[@id=\"search_product\"]");
    By Searchbutton = By.xpath("//button[@id=\"submit_search\"]");
    By ProductTitle = By.xpath("//*[@class=\"title text-center\"]");
    By PageContent = By.xpath("//*[@class=\"features_items\"]");
    By FirstProduct=By.xpath("(//a[@data-product-id=\"1\"])[1]");
    By IntialPrice1 = By.xpath("//*[@class=\"product-image-wrapper\"]//h2");
    By IntialPrice2 =By.xpath("//a[@data-product-id=\"2\"]//parent::div//h2");
    By ContinueShopping = By.xpath("//button[@data-dismiss=\"modal\"]");
    By SecondProduct = By.xpath("(//a[@data-product-id=\"2\"])[1]");
    By ViewCartButton=By.xpath("(//*[@href=\"/view_cart\"])[2]");
    By Cart1=By.xpath("//*[@href=\"/product_details/1\"]");
    By Price1 =By.xpath("(//td[@class=\"cart_price\"])[1]");
    By QuantitY1 =By.xpath("(//button[@class=\"disabled\"])[1]");
    By Total1= By.xpath("(//*[@class=\"cart_total_price\"])[1]");
    By Cart2= By.xpath("//*[@href=\"/product_details/2\"]");
    By Price2 =By.xpath("(//td[@class=\"cart_price\"])[2]");
    By Quantity2 =By.xpath("(//button[@class=\"disabled\"])[2]");
    By Total2=By.xpath("(//*[@class=\"cart_total_price\"])[2]");






    WebDriver driver;
    public ProductPage(WebDriver webDriver) {

        this.driver= webDriver;

    }

    public void openProductPage() {
    driver.findElement(ProductButton).click();
}
public String GetProductTile(){
        return  driver.findElement(AllProductTitle).getText();
}
public void AddAnyProduct(String product){
        driver.findElement(SearchPlaceholder).sendKeys(product);
        driver.findElement(Searchbutton).click();
}
public String GetProductInfo(){
        return driver.findElement(ProductTitle).getText();

             }

public String GetPageContent(){
        return driver.findElement(PageContent).getText();
}
public void AddProduct1() {
    Actions action = new Actions(driver);

    action.moveToElement(driver.findElement(FirstProduct)).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(ContinueShopping).click();

}
public void AddProduct2(){
    Actions action = new Actions(driver);
    action.moveToElement(driver.findElement(SecondProduct)).click();
    driver.findElement(ViewCartButton).click();
}
    public String viewFirstproduct(){
        return driver.findElement(Cart1).getText();

}
    public String viewFirstPrice(){
        return driver.findElement(Price1).getText();
}
    public String viewFirstQuantity(){
        return driver.findElement(QuantitY1).getText();
}
public String viewTotalPrice1(){
        return driver.findElement(Total1).getText();

}
    public String viewSecondproduct(){
        return driver.findElement(Cart2).getText();

    }
    public String viewSecondQuantity(){
        return driver.findElement(Price2).getText();

    }
    public String viewTotalPice2 (){
        return driver.findElement(Total2).getText();
    }
    public String getPrice1(){
       return driver.findElement(IntialPrice1).getText();
    }

    public String getPrice2(){
       return driver.findElement(IntialPrice2).getText();
    }


}
