package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    @FindBy(xpath="//input[@id=\"first-name\"]") private WebElement firstname;
    @FindBy(xpath="//input[@id=\"last-name\"]") private WebElement lastName;
    @FindBy(xpath="//input[@id=\"postal-code\"]") private WebElement postleCode;
    @FindBy(xpath="//button[@name=\"cancel\"]") private WebElement cancle;
    @FindBy(xpath="//input[@id=\"continue\"]") private WebElement Continue;

    public CheckOutPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void sendKeysOnFirstName(String name)
    {
        firstname.sendKeys(name);
    }
    public void sendKeysOnlastname(String lastname)
    {
        lastName.sendKeys(lastname);
    }
    public void sendKeysOnPostleCode(String code)
    {
        postleCode.sendKeys(code);
    }
    public void clickOnCancle()
    {
        cancle.click();
    }
    public void clickOnContinue()
    {
        Continue.click();
    }

}
