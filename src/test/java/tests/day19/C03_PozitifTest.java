package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PozitifTest {
    @Test
    public void pozitifTest() {

        /*
        Page class'ındaki locate'lerimize ulaşabilmek için
        Page classımızdan bir obje oluşturarak, oluşturmuş olduğumuz obje ile
        page classımızdaki locate'lerimize ulaşabiliriz
        */
        //https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCamppage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        // login butonuna bas
        hotelMyCamppage.login.click();

        //test data username: manager ,
        // test data password : Manager1!
        hotelMyCamppage.userName.sendKeys(ConfigReader.getProperty("hmcUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPassword")).
                    sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCamppage.girisYapildi.isDisplayed());


    }

}
