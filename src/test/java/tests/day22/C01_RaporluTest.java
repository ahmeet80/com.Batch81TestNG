package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.swing.*;

public class C01_RaporluTest extends TestBaseRapor {
    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test", "Gecerli kullanici adi ve password ile giris yapildi");
      //-https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar Sitesine Gidildi");
        Actions action =new Actions(Driver.getDriver());
      // -login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.brcLogin.click();
        extentTest.info("Login butonuna basildi");


      // -test data user email: customer@bluerentalcars.com ,
        // -test data password : 12345 dataları girip login e basın
        // -login butonuna tiklayin
        brcPage.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        action.sendKeys(Keys.TAB,ConfigReader.getProperty("pass"),
                Keys.ENTER).perform();
        extentTest.info("Dogru kullanici email ve password girildi ");
        extentTest.info("ikinci login butonuna basildi");


      // -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String expectedUserName = "John Walker";
        String actualUserName = brcPage.userNameWE.getText();
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");
    }
}
