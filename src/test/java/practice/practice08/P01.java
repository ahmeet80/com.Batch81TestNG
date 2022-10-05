package practice.practice08;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuappTestPage;
import utilities.Driver;

import javax.swing.*;
import java.util.List;

public class P01 {
    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    HerokuappTestPage herokuappTestPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        herokuappTestPage = new HerokuappTestPage();
        // kodlarımızı yazarken clean code

        herokuappTestPage.onBlur.click();
        herokuappTestPage.onClick.click();
        herokuappTestPage.onClick.click();
        actions.contextClick(herokuappTestPage.contextMenu).
                doubleClick(herokuappTestPage.doubleClick).
                click(herokuappTestPage.onFocus).
                click(herokuappTestPage.keyDown).
                sendKeys(Keys.ENTER).
                click(herokuappTestPage.keyUp).
                sendKeys(Keys.ENTER).
                click(herokuappTestPage.keyPress).
                sendKeys(Keys.ENTER).
                moveToElement(herokuappTestPage.mouseOver).
                moveToElement(herokuappTestPage.mouseLeave).
                moveToElement(herokuappTestPage.mouseOver).
                click(herokuappTestPage.mouseDown).perform();

        Thread.sleep(2000);

    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        List<WebElement> clicked = herokuappTestPage.eventTriggered;
        Assert.assertEquals(clicked.size(),11);

    }
}
