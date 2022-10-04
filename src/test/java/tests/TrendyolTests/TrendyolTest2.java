package tests.TrendyolTests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TrendyolPage2;
import utilities.ConfigReader;
import utilities.Driver;

// 1 ) Bir Class olustur : NegativeTest
public class TrendyolTest2 {
        // 2) Bir test method olustur NegativeLoginTest()
    @Test
    public void testNegative() {

        // https://www.trendyol.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("trndylUrl"));
        // Çerezleri kabul et
        TrendyolPage2 trendyolPage2 = new TrendyolPage2();
        trendyolPage2.acceptCokie.click();

        // login butonuna bas
        trendyolPage2.mainLogin.click();

        // test data username: manager1
        // test data password : manager1!
        trendyolPage2.emailBox.sendKeys(ConfigReader.getProperty("trndylNegativeUsername"),
                Keys.TAB,ConfigReader.getProperty("trndylNegativePassword"),Keys.ENTER);

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(trendyolPage2.negativeMessage.isDisplayed());

    }

    @Test
    public void testPositive() throws InterruptedException {
        // https://www.trendyol.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("trndylUrl"));
        // Çerezleri kabul et
        TrendyolPage2 trendyolPage2 = new TrendyolPage2();
        trendyolPage2.acceptCokie.click();

        // login butonuna bas
        trendyolPage2.mainLogin.click();

        // test data username: trndylPozitiveUsername (key degerleri)
        // test data password : trndylPozitivePassword (key degerleri)
        trendyolPage2.emailBox.sendKeys(ConfigReader.getProperty("trndylPozitiveUsername"),
                Keys.TAB,ConfigReader.getProperty("trndylPozitivePassword"),Keys.ENTER);
        Thread.sleep(3000);
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedPositiveText ="Hesabım";
        String actualPositiveText = trendyolPage2.positiveAccount.getText();
        System.out.println(trendyolPage2.positiveAccount.getText());
        Assert.assertEquals(expectedPositiveText,actualPositiveText,"Test Gecmedi");

        // Nutella aratiniz
        Thread.sleep(1000);
        trendyolPage2.searchBox.sendKeys("Nutella",Keys.ENTER);

        // ilk siradaki urunu sepete ekleyin
        trendyolPage2.firstProductAddBox.click();

        // sepete gidip urunun sepete eklendigini test edin
        trendyolPage2.basket.click();
        Assert.assertTrue(trendyolPage2.orderSummary.isDisplayed());






    }
}
