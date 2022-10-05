package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    // Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    // priority methodunu kullanırız
    // priority kullanmazsak priority = 0 kabul edilir (priorty olarak negatif degerlerde verilebilir)
    

    @Test (priority = 1)
    public void youtubeTest() {

        driver.get("https://youtube.com");
    }

    @Test (priority = 3)
    public void bestbuyTest() {

        driver.get("https://bestbuy.com");
    }

    @Test (priority = 2)
    public void amazonTest() {

        driver.get("https://amazon.com");
    }

    @Test (priority = -1, groups = "gp1")
    public void hepsiburadatest() {
        driver.get("https://hepsiburada.com");
    }
}
