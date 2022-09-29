package tests.day18;

import org.testng.annotations.Test;
import pages.HotelMyCamp_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    @Test
    public void test01() {
        HotelMyCamp_Page hotelMyCamp_page = new HotelMyCamp_Page();

        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));


        //test data username: manager ,  test data password : Manager1!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelMyCamp_page.login.click();


    }
}
