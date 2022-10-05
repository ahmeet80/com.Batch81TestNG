package tests.day21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class day21_HomeWork_OgrY {
    @Test
    public void test01() throws IOException, InterruptedException {

        Driver.getDriver().get("https://hepsiburada.com/");
        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();
     // Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i <  66; i++) {
     //    Thread.sleep(100);
     //    for (int j = 0; j < 10; j++) {

     //        actions.sendKeys(Keys.ARROW_DOWN);
     //    }
          hepsiBuradaPage.elektronikButton.click();
          ReusableMethods.hover(hepsiBuradaPage.elektronikButton);
          ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3);
          ReusableMethods.hover(hepsiBuradaPage.bilgisayarTabletButton);
          ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3);
          hepsiBuradaPage.sixtysixWE.get(i).click();

           //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
                //String pageSource = Driver.getDriver().getPageSource().toString();
                //Assert.assertTrue(pageSource.contains(hepsiBuradaPage.sixtysixWE.get(i).toString()));
          ReusableMethods.getScreenshot("hepsiburada - ");
          Driver.getDriver().navigate().back();

       }


    }
}

