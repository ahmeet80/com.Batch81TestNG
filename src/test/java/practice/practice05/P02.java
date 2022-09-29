package practice.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class P02 extends TestBaseBeforeClassAfterClass {
    // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
    // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
    // 3. Açılır metni alın
    // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
    // 5. Açılır pencereyi kabul edin


    @Test
    public void test01() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//span[@id='button1']")).click();
        // 3. Açılır metni alın
        String actualText = driver.switchTo().alert().getText();
        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedText = "I am an alert box!";
        Assert.assertEquals(expectedText,actualText);
        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}
