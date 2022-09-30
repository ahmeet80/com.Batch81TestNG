    package pages;

    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import utilities.Driver;

    public class HotelMyCamp_Page {
        public HotelMyCamp_Page(){

            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy (xpath = "//li[@id='navLogon']")
        public WebElement login;

        @FindBy (xpath = "//input[@id='UserName']")
        public WebElement userName;

        @FindBy (xpath = "//span[@class='username username-hide-on-mobile']")
        public WebElement girisYapildi;

        @FindBy (xpath = "//*[text()='Try again please']")
        public WebElement girisYapilamadi;
    }
