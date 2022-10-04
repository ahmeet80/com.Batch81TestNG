package practice.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniverstyPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
    // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
    //Tüm yapılacakların üzerini çiz.
    //Tüm yapılacakları sil.
    //Tüm yapılacakların silindiğini doğrulayın.

    //EXPLOTARY testing


    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
        WebUniverstyPage webUniverstyPage = new WebUniverstyPage();

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
            // Buradaki listeyi listeyi yapilacaklar listesine tek tek manuel olarak eklemek yerine loop kullanarak toplu
            // bir sekilde sırasıyla gonderebilmek amacı ile oluşturduk
        List<String> workList = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka",
                "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions = new Actions(Driver.getDriver());
        for(String w:workList){
            actions.click(webUniverstyPage.addNewTodo).sendKeys(w, Keys.ENTER).perform();
        }

        //Tüm yapılacakların üzerini çiz.
            List<WebElement> todos = webUniverstyPage.todosWebElement;
        for(WebElement w:todos){
            w.click();
        }

        Thread. sleep(2000);
            List<WebElement> deleteButtons = webUniverstyPage.deleteButtonsWebElement;
            for(WebElement w: deleteButtons){
                w.click();
            }


        //Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniverstyPage.todosWebElement;
        System.out.println(newtodos.size());
        Thread.sleep(2000);
        System.out.println(newtodos.size());
        Assert.assertEquals(newtodos.size(),0);

    }
}
