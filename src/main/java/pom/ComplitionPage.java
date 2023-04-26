package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplitionPage {

    @FindBy(xpath = "//h2[text()='Thank you for your order!']") private WebElement title;
    @FindBy(xpath = "//img[@alt=\"Pony Express\"]") private WebElement logo;
    @FindBy(xpath = "//button[@id=\"back-to-products\"]") private WebElement backHome;

    public ComplitionPage(WebDriver driver)
    {
        PageFactory.initElements( driver,this);
    }

    public void visibilityOfLogo()
    {
        logo.isDisplayed();
    }

    public boolean getTitle()
    {
        return title.isDisplayed();
    }
    public void clickOnBackHome()
    {
        backHome.click();
    }


}
