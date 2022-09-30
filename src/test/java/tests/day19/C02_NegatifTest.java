package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegatifTest {
    @Test
    public void negatifTest() {
        //1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        HotelMyCamp_Page hotelMyCamp_page = new HotelMyCamp_Page();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //login butonuna bas
        hotelMyCamp_page.login.click();

        //test data username: manager1 ,
        // test data password : manager1!
        hotelMyCamp_page.userName.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongUserPass")).
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCamp_page.girisYapilamadi.isDisplayed());

        //Sayfayi kapatınız
        Driver.closeDriver();
    }
}
