package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){ // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        // Eğer browser'a bir değer atanmamışsa properties dosyası'ndaki browser çalışır.
        browser = browser==null ? ConfigReader.getProperty("browser") : browser;
        // Testlerimizi xml file'dan farklı browserlar ile calistirabilmek için getDriver() methodu'na parametre
        // atamamız gerekir
        if (driver == null) {
            switch (browser){
                case "chrome" :
                    // CrossBrowser için bizim gönderdiğimiz browser üzerinden çalışması için
                    // buraya paramaetre olarak girdiğimiz değeri yazdık
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
