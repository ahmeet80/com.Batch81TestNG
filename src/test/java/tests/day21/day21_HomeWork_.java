package tests.day21;

import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class day21_HomeWork_ {
    @Test
    public void test01() throws IOException, InterruptedException {

        Driver.getDriver().get("https://hepsiburada.com/");

        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();


        hepsiBuradaPage.elektronikButton.click();                                           // sixtysixWE liste atama
        ReusableMethods.hover(hepsiBuradaPage.elektronikButton);                            // yapılabilmesi için açılır
        ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3); // menunun en az bir defa
        ReusableMethods.hover(hepsiBuradaPage.bilgisayarTabletButton);                      // gorunurolması gerekir

        int sixtysixCount = hepsiBuradaPage.sixtysixWE.size();
        // Actions actions = new Actions(Driver.getDriver());
        for (int i = 63; i <  sixtysixCount; i++) {

          hepsiBuradaPage.elektronikButton.click();
          ReusableMethods.hover(hepsiBuradaPage.elektronikButton);
          ReusableMethods.waitForVisibility(hepsiBuradaPage.bilgisayarTabletButton,3);
          ReusableMethods.hover(hepsiBuradaPage.bilgisayarTabletButton);
          ReusableMethods.waitForVisibility(hepsiBuradaPage.sixtysixPlace,3); // 66 Webelementi barındıran bos alan
          hepsiBuradaPage.sixtysixWE.get(i).click();

           //Her linkten sonra o sayfaya gittimizi test edelim
                //String pageSource = Driver.getDriver().getPageSource().toString();                    // Bu kısım olmadı
                //Assert.assertTrue(pageSource.contains(hepsiBuradaPage.sixtysixWE.get(i).toString()));
            // Herbir sayfanın resmini alalım
          ReusableMethods.getScreenshot("hepsiburada - ");
          Driver.getDriver().navigate().back();

       }


    }
}

