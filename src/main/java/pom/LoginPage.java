package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath="(//input[@class='input_error form_input'])[1]") private WebElement userName;
    @FindBy(xpath="(//input[@class='input_error form_input'])[2]") private WebElement password;
    @FindBy(xpath="//input[@class='submit-button btn_action']") private WebElement login;
    @FindBy(xpath="//div[@class='error-message-container error']") private WebElement errorMsg;
    //	@FindBy(xpath="") private WebElement ;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void SendKeysOnUserName(String user)
    {
        userName.sendKeys(user);
    }

    public void SendKeysOnPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clickOnLogin()
    {
        login.click();
    }
    public boolean visualisationOfErrorMsg()
    {
        return errorMsg.isDisplayed();
    }


}
