package tests.day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;

public class day21_HomeWork {
    @Test
    public void testHepsiburada() {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("hbsbrdUrl"));

        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(5);


        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        //Sayfayı kapatalım

    }

}
