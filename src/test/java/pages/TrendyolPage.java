package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolPage {
    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//*[@class='link-text'])[1]")
    public WebElement mainLogin;

    @FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement allowCokie;

    @FindBy (xpath = "(//*[@class='q-input'])[1]")
    public WebElement emailBox;

    @FindBy (xpath = "//*[@class='message']")
    public WebElement negativeMessage;

    @FindBy (xpath = "//*[@class='link-text']")
    public WebElement positiveAccount;

    @FindBy (xpath = "//input[@class='vQI670rJ']")
    public WebElement searchBox;

    @FindBy (xpath = "(//div[@class='add-to-bs-tx'])[2]")
    public WebElement firstProductAddBox;

    @FindBy (xpath = "(//p[@class='link-text'])[3]")
    public WebElement basket;

    @FindBy (xpath = "//div[@class='pb-summary-box']")
    public WebElement orderSummary;

}
