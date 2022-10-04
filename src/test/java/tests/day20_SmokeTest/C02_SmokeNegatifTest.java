package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegatifTest {
    @Test
    public void yanlisKullanici() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCamppage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        hotelMyCamppage.login.click();

        //test data username: manager1 ,
        // test data password : manager1!
        hotelMyCamppage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName")); // yanlis kullanici adi
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPassword")). //dorgu sifre
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCamppage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatınız
        Driver.closeDriver();
    }
    @Test
    public void yanlisSifre() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelm    ycamp.com/ adresine git
        HotelMyCampPage hotelMyCamppage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        hotelMyCamppage.login.click();

        //test data username: manager1 ,
        // test data password : manager1!
        hotelMyCamppage.userName.sendKeys(ConfigReader.getProperty("hmcUserName")); // dogru kullanici adi
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongUserPass")). //yanlis sifre
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCamppage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatınız
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciSifre() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCamppage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        hotelMyCamppage.login.click();

        //test data username: manager1 ,
        // test data password : manager1!
        hotelMyCamppage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName")); // yanlis kullanici adi
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongUserPass")). //yanlis sifre
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCamppage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatınız
        Driver.closeDriver();
    }
}
