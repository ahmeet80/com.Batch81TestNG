package tests.day16;


import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void testAmazon() {
        driver.get("https://amazon.com");

    }

    @Test
    public void testBestBuy() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void testTechProed() {
        driver.get("https://techproeducation.com");
    }

}
