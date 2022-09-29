package tests.day17;

public class day17_Odev01 {


}



/*
package tests.zTEKRAR_NG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class Eyl29_Hw01 extends TestBaseBeforeClassAfterClass {

    //Bir class oluşturun: DependsOnTest
    //https://www.amazon.com/ adresine gidin.
    //Test : Amazon ana sayfaya gittiginizi test edin
    //Test : 1.Test basarili ise search Box'i kullanarak "Nutella" icin
    //arama yapin ve aramanizin gerceklestigini Test edin
    //Test : "Nutella" icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //$16.83 oldugunu test edin (NOT = BU TESTEKİ PARASAL BİRİME ULAŞAMADIGIMIZ İÇİN BAŞKA BİR YERİ LOCATE ETTİK. HERKESİN BİLGİSİNE. DİREKSİYONUN BAŞINDA KİMİN OLDUGUNU GÖSTERDİK MUHATAPLARIMIZA :) )


    @Test
    public void test01() {
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Test : Amazon ana sayfaya gittiginizi test edin
       WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
//Test : 1.Test basarili ise search Box'i kullanarak "Nutella" icin
        //arama yapin ve aramanizin gerceklestigini Test edin
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Nutella", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.isDisplayed(), "Result is not displayed");

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //Test : "Nutella" icin arama yapildiysa ilk urunu tiklayin ve agırlıgının
        //26.5 oz oldugunu test edin

        String text = driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        String expectedWeight ="26.5 oz";
        Assert.assertTrue(text.contains(expectedWeight));
    }
}
 */