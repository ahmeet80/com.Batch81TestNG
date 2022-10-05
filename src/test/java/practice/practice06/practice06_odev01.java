package practice.practice06;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class practice06_odev01 {
    @Test
    public void test01() {
        //     * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("scdmUrl"));
        //     * Enter the username  as standard_user
        SauceDemoPage saucedemoPage = new SauceDemoPage();
        saucedemoPage.userName.sendKeys(ConfigReader.getProperty("scdmUserName"));

        //     * Enter the password as   secret_sauce
        saucedemoPage.password.sendKeys(ConfigReader.getProperty("scdmPassword"));
        Actions actions = new Actions(Driver.getDriver());
        //     * Click on login button
        actions.sendKeys(Keys.ENTER).perform();
        //     * Ekranda cıkan allerte tamam deyip gecelim (cıkmadı canımıza minnet)
        //     * Choose price low to high
        Select select = new Select(saucedemoPage.ddm);
        select.selectByIndex(2);
        //       and verify that PRICE (LOW TO HIGH) is visible
        Assert.assertTrue(select.getFirstSelectedOption().isDisplayed());
        Driver.closeDriver();

    }


}
