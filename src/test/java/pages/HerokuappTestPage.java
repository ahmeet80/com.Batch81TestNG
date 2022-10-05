package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HerokuappTestPage {
    public HerokuappTestPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//button[@id='onblur']")
    public WebElement onBlur;

    @FindBy (xpath = "//button[@id='onclick']")
    public WebElement onClick;

    @FindBy (xpath = "//button[@id='oncontextmenu']")
    public WebElement contextMenu;

    @FindBy (xpath = "//button[@id='ondoubleclick']")
    public WebElement doubleClick;

    @FindBy (xpath = "//button[@id='onfocus']")
    public WebElement onFocus;

    @FindBy (xpath = "//button[@id='onkeydown']")
    public WebElement keyDown;

    @FindBy (xpath = "//button[@id='onkeyup']")
    public WebElement keyUp;

    @FindBy (xpath = "//button[@id='onkeypress']")
    public WebElement keyPress;

    @FindBy (xpath = "//button[@id='onmouseover']")
    public WebElement mouseOver;

    @FindBy (xpath = "//button[@id='onmouseleave']")
    public WebElement mouseLeave;

    @FindBy (xpath = "//button[@id='onmousedown']")
    public WebElement mouseDown;

    @FindBy (xpath = "//p[.='Event Triggered']")
    public List<WebElement> eventTriggered;



}
