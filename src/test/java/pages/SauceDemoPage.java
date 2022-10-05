package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {
    public SauceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //WebElement userName = driver.findElement(By.id("user-name"));
    }
    @FindBy (id = "user-name")
    public WebElement userName;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy (className = "product_sort_container")
    public WebElement ddm;



}
