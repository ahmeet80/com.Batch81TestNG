package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroBankPage {

    public ZeroBankPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[@id='signin_button']")
    public WebElement signIn;

    @FindBy (xpath = "//input[@id='user_login']")
    public WebElement loginBox;

    @FindBy (xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement submitSignIn;

    @FindBy (xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBanking;

    @FindBy (xpath = "//span[@id='pay_bills_link']")
    public WebElement payBills;

    @FindBy (xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purForCur;

    @FindBy (xpath = "//select[@id='pc_currency']") // check later !!!
    public WebElement currencyDropDownMenu;

    @FindBy (xpath = "//select[@id='pc_currency']") // check later !!!
    public List<WebElement> currencyDropDownMenuList;
}
