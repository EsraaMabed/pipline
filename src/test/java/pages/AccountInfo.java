package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;

public class AccountInfo {
    WebDriver driver;

    public AccountInfo(WebDriver webDriver) {

        this.driver = webDriver;
    }


    By Account = By.xpath("//*[@class=\"title text-center\"][1]");
    By Title = By.xpath("//*[@id=\"uniform-id_gender2\"]");
    By Password = By.xpath("//*[@id=\"password\"]");
     By DayOfBirth = By.xpath("//*[@id=\"days\"]");

    By MonthOfBirth = By.xpath("//*[@id=\"months\"]");
    By YearOfBirth = By.xpath("//*[@id=\"years\"]");
    By Newsletter = By.xpath("//input[@id=\"newsletter\"]");
    By Offers = By.xpath("//input[@id=\"optin\"]");

       By Firstname =By.xpath("//input[@id=\"first_name\"]");
       By Lastname = By.xpath("//input[@id=\"last_name\"]");
       By  Company =By.xpath("//input[@id=\"company\"]");
       By Address=By.xpath("//input[@id=\"address1\"]");
       By Address2=By.xpath("//input[@id=\"address2\"]");
       By Country=By.xpath("//select[@id=\"country\"]");
       By State=By.xpath("//input[@id=\"state\"]");
       By City=By.xpath("//input[@id=\"city\"]");
       By Zipcode=By.xpath("//input[@id=\"zipcode\"]");
       By MobileNumber =By.xpath("//input[@id=\"mobile_number\"]");
       By Creatbutton = By.xpath("//button[@data-qa=\"create-account\"]");
       By CreationStatment= By.xpath("//*[@data-qa]");
       By Contine =By.xpath("//*[@data-qa=\"continue-button\"]");

       By LoggedUser = By.xpath("//*[@class=\"nav navbar-nav\"]/li/a/b");
       By DeleteButton = By.xpath("//*[@href=\"/delete_account\"]");
       By DeleteMessage = By.xpath("//*[@class=\"title text-center\"]");

    public String AccountTitle(){
       return driver.findElement(Account).getText();
    }
    public void setPersonalInformation(String password,int index,int index1,String text2){
        driver.findElement(Title).click();
        driver.findElement(Password).sendKeys("password");
        Select Day = new Select(driver.findElement(DayOfBirth));
        Day.selectByIndex(index);
        Select Month = new Select(driver.findElement(MonthOfBirth));
        Month.selectByIndex(index1);
        Select year = new Select(driver.findElement(YearOfBirth));
        year.selectByVisibleText(text2);

    }

    public void selectCheckbox(){
        driver.findElement(Newsletter).click();
        driver.findElement(Offers).click();
    }
    public void setAdressInformation(String fname,String lname,String company,String adress,
                                     String adress2,int index,
                                     String state,String city,String zipcode,String mobilenumber){

        driver.findElement(Firstname).sendKeys(fname);
        driver.findElement(Lastname).sendKeys(lname);
        driver.findElement(Company).sendKeys(company);
        driver.findElement(Address).sendKeys(adress);
        driver.findElement(Address2).sendKeys(adress2);
        Select country = new Select(driver.findElement(Country));
        country.selectByIndex(index);
        driver.findElement(State).sendKeys(fname);
        driver.findElement(City).sendKeys(city);
        driver.findElement(Zipcode).sendKeys(zipcode);
        driver.findElement(MobileNumber).sendKeys(mobilenumber);

        driver.findElement(Creatbutton).click();
    }
    public String SuccessCreation(){
       return driver.findElement(CreationStatment).getText();
    }
    public void Continue(){
       driver.findElement(Contine).click();
    }
    public String userLogged(){
        return driver.findElement(LoggedUser).getText();
    }
    public void deleteAccount(){
        driver.findElement(DeleteButton).click();
    }
    public String deleteMessage(){
        return driver.findElement(DeleteMessage).getText();
    }




}