package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {
    @Test
    public void test01() {
        // Amazon sayfasina ve facebook sayfasina gidiniz
        String urlAmzn = ConfigReader.getProperty("amznUrl");
        String urlFace = ConfigReader.getProperty("faceUrl");
        Driver.getDriver().get(urlAmzn);
        Driver.getDriver().get(urlFace);
        Driver.closeDriver();

    }
}
