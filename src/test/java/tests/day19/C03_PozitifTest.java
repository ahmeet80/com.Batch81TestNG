package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCamp_Page;
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
        HotelMyCamp_Page hotelMyCamp_page = new HotelMyCamp_Page();
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        // login butonuna bas
        hotelMyCamp_page.login.click();

        //test data username: manager ,
        // test data password : Manager1!
        hotelMyCamp_page.userName.sendKeys(ConfigReader.getProperty("hmcUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPassword")).
                sendKeys(Keys.TAB,Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCamp_page.girisYapildi.isDisplayed());

    }

}
