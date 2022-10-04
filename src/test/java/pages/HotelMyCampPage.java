    package pages;

    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import utilities.Driver;

    public class HotelMyCampPage {
        public HotelMyCampPage(){

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

        @FindBy (xpath = "(//span[@class='title'])[3]")
        public WebElement hotelManagement;

        @FindBy(xpath = "(//*[@class='icon-calendar'])[4]")
        public WebElement roomReservation;

        @FindBy(xpath = "//*[text()='Add Room Reservation ']")
        public WebElement addRoom;

        @FindBy(xpath = "//select[@id='IDUser']")
        public WebElement idUser;

        @FindBy(xpath = "//div[@class='bootbox-body']")
        public WebElement getRoomReservationText;

        @FindBy(xpath = "//button[@class='btn btn-primary']")
        public WebElement okButton;
    }
