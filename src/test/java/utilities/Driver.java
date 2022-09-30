package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class Driver {


    private Driver(){ // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor

    }

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
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver =new FirefoxDriver();
                    break;
                case "opera" :
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "headless_chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

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
