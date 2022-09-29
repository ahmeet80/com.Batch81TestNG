package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    /*
    Testlerimizi calist,rdigimizda her seferinde yeni driver olusturdugu icin her test methodu
     icin yeni bir pencere aciyor. Eger driver'a bir deger atanmamissa yani driver==null ise
     bir kere driver'i calistir diyerek bir kere if'in icini calistiracak ve driver artik
     bir kere calisip deger atandigi icin null olmayacak ve direkt return edecek ve diger
     testlerimiz ayni pencere(driver) uzerinde calisacak
     */

    public static WebDriver getDriver() {
        if (driver == null) { // coklu cagirmada ayni browserda acmak icin
            WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a deger atanmissa kapat
            driver.close();
            driver = null; // bir dahaki calisma icin garanti altina almak icin driver'i null yaptik (sifirladik)
        }
    }

    public static void quitDriver() {
        if (driver != null) { // driver'a deger atanmissa kapat
            driver.quit();
            driver = null; // bir dahaki calisma icin garanti altina almak icin driver'i null yaptik (sifirladik)
        }

    }
}
