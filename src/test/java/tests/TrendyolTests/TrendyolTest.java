package tests.TrendyolTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

// 1 ) Bir Class olustur : NegativeTest
public class TrendyolTest {
        // 2) Bir test method olustur NegativeLoginTest()
    @Test
    public void testNegative() {

        // https://www.trendyol.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("trndylUrl"));
        TrendyolPage trendyolPage  = new TrendyolPage();
        Actions actions = new Actions(Driver.getDriver());

        // Çerezleri kabul et
        trendyolPage.allowCokie.click();

        // login butonuna bas
        trendyolPage.mainLogin.click();

        // test data username: manager1
        // test data password : manager1!
        trendyolPage.emailBox.sendKeys(ConfigReader.getProperty("trndylNegativeUsername"));
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("trndylNegativePassword")).
                sendKeys(Keys.ENTER).perform();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(trendyolPage.negativeMessage.isDisplayed());
    }

    @Test
    public void testPositive() throws InterruptedException {
        // https://www.trendyol.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("trndylUrl"));
        TrendyolPage trendyolPage  = new TrendyolPage();
        Actions actions = new Actions(Driver.getDriver());

        // Çerezleri kabul et
        trendyolPage.allowCokie.click();

        // login butonuna bas
        trendyolPage.mainLogin.click();

        // test data username: matcode3460@gmail.com
        // test data password : Manager1!
        trendyolPage.emailBox.sendKeys(ConfigReader.getProperty("trndylPozitiveUsername"));
        actions.sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("trndylPozitivePassword")).
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedPositiveText ="Hesabım";
        String actualPositiveText = trendyolPage.positiveAccount.getText();
        //System.out.println(actualPositiveText);
        Assert.assertEquals(expectedPositiveText,actualPositiveText,"Giris Yapilamadi");
        // Nutella aratiniz
        Thread.sleep(1000);
        trendyolPage.searchBox.sendKeys("nutella",Keys.ENTER);
        // ilk siradaki urunu sepete ekleyin
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        trendyolPage.firstProductAddBox.click();
        // sepete gidip urunun sepete eklendigini test edin
        trendyolPage.basket.click();
        Assert.assertTrue(trendyolPage.orderSummary.isDisplayed());


    }
}
