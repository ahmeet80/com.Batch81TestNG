package practice.practice09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.TestBaseCross;
import utilities.TestBaseRapor;

public class SearchProductTest extends TestBaseRapor {
    // 1. Tarayıcıyı başlat
    // 2. 'http://automationexercise.com' url'sine gidin
    // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    // 4. 'Ürünler' butonuna tıklayın
    // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
    // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
    // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
    // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
    SearchProductPage searchProductPage = new SearchProductPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void searchProductPage() throws InterruptedException {
        extentTest=extentReports.createTest("automation", "fdsfdf");
        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        extentTest.info(" // 1. Tarayıcıyı baslat 2. 'http://automationexercise.com' url'sine gidin");

        Driver.getDriver().get("http://automationexercise.com");


        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String homeUrl = "https://automationexercise.com/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),homeUrl);
        extentTest.info(" 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın");

        // 4. 'Ürünler' butonuna tıklayın
        searchProductPage.product.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(searchProductPage.allProductTitle.isDisplayed());

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın ("C")
        searchProductPage.searchBox.sendKeys("blue");
        searchProductPage.searchButton.click();
        //actions.click(searchProductPage.searchBox);

        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(searchProductPage.searchedProductTitle.isDisplayed());
        for(WebElement w:searchProductPage.searchProductList){
            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(500);
        }

        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
        actions.click(searchProductPage.viewProduct);
        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());
        extentTest.info(" Arama ile ilgili urun dogrulandi");
    }
}
