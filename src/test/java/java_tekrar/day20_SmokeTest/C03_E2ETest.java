package java_tekrar.day20_SmokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() throws InterruptedException {

        //https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();

        //Username textbox ve password metin kutularını locate edin ve asagidaki verileri kullanın
        //Username : manager
        //Password  : Manager1!
        // login butonuna tıklayın
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("hmcUserName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcPassword")).
                sendKeys(Keys.ENTER).perform();

        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampPage.hotelManagement.click();
        Thread.sleep(2000);
        hotelMyCampPage.roomReservation.click();
        Thread.sleep(2000);
        hotelMyCampPage.addRoom.click();

        //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //Save butonuna tıklayın.
        Faker faker = new Faker();
        hotelMyCampPage.idUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/12/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2").
                sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("skajdlaksjdaasd").
                sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        //actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
        //        sendKeys(Keys.TAB,"1500",Keys.TAB,"10/02/2022"
        //                ,Keys.TAB,Keys.TAB,"10/13/2022",Keys.TAB,Keys.TAB,"2",Keys.
        //                TAB,"2",Keys.TAB,faker.name(),Keys.TAB,faker.phoneNumber(),Keys.
        //                TAB,faker.internet().emailAddress(),Keys.TAB,"I like this",Keys.TAB).perform();





        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampPage.getRoomReservationText.isDisplayed());

        //OK butonuna tıklayın.
        hotelMyCampPage.okButton.click();

    }
}
