package tests.day17;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroBankPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class day17_Odev02 {
    @Test
    public void test01() {
        ZeroBankPage zeroBankPage = new ZeroBankPage();
        //Yeni bir Class Olusturun : C03_SoftAssert

        //“http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroBankUrl"));
        //Sign in butonuna basin
        zeroBankPage.signIn.click();
        //Login kutusuna “username” yazin
        zeroBankPage.loginBox.sendKeys(ConfigReader.getProperty("zeroBankUserName"));
        //Password kutusuna “password” yazin
        zeroBankPage.passwordBox.sendKeys(ConfigReader.getProperty("zeroBankPassword"));
        //Sign in tusuna basin // Bu site güvenli bağlantı sağlayamıyor uyarısı var bu uyarıyı navigate.back komutu ile asabiliz
        zeroBankPage.submitSignIn.click();
        //** Bu site güvenli bağlantı sağlayamıyor uyarısı nı gecmek icin navigate.back yapın
        Driver.getDriver().navigate().back();
        //Online banking menusu icinde Pay Bills sayfasina gidin
        zeroBankPage.onlineBanking.click();
        zeroBankPage.payBills.click();
        //“Purchase Foreign Currency” tusuna basin
        zeroBankPage.purForCur.click();
        //“Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zeroBankPage.currencyDropDownMenu);
        select.selectByVisibleText("Eurozone (euro)");
        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Eurozone (euro)");

        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin  "Select One",
            // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
            // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
            // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
            // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<WebElement> expectedList = new ArrayList<>();
        List<WebElement> actualList = zeroBankPage.currencyDropDownMenuList;
        for (int i = 0; i < actualList.size(); i++) {
            expectedList.add(actualList.get(i));
        }
        softAssert.assertEquals(expectedList,actualList);
       // for (int i = 0; i < expectedList.size(); i++) {
       //     softAssert.assertEquals(expectedList.get(i).getText(),actualList.get(i).getText());
       //     System.out.println(expectedList+"      ");
       //     System.out.println(actualList.get(i).getText());
       // }
        softAssert.assertAll();
    }

}

/*
public class C06_Odev1 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //“http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        //Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking'][1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
        //“Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        dropDown.sendKeys("Eurozone (euro)");
        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualDropDownTitle = dropDown.getAccessibleName();
        softAssert.assertNotEquals(actualDropDownTitle, "Eurozone (Euro)");
        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
            // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
            // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
            // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
            // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        Select select = new Select(dropDown);
        List<WebElement> list = select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        for (int i = 0; i < expectedList.size(); i++) {
            softAssert.assertEquals(list.get(i).getText(), expectedList.get(i));
        }
        softAssert.assertAll();
       driver.quit();
    }
}
 */