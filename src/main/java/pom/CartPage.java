package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


    @FindBy(xpath="//div[@class=\"cart_item\"]") private List<WebElement> containers ;
    @FindBy(xpath="//*[@class=\"btn btn_secondary btn_small cart_button\"]") private WebElement remove ;
    @FindBy(xpath="//div[@class=\"inventory_item_price\"]") private List<WebElement> productPrice;
    @FindBy(xpath="//div[text()=\"Swag Labs\"]") private WebElement swaglabs;
    @FindBy(xpath="//button[@class=\"btn btn_secondary back btn_medium\"]") private WebElement continueShopping;
    @FindBy(xpath="//button[@id=\"checkout\"]") private WebElement chekout;
    @FindBy(xpath="//button[@id=\"react-burger-menu-btn\"]") private WebElement functinality;
    @FindBy(xpath="(//a[@class=\"bm-item menu-item\"])[1]") private WebElement allItems;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[2]") private WebElement about;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[3]") private WebElement logOut;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[4]") private WebElement resetAppState;
    @FindBy(xpath="(//button[@name=\"back-to-products\"])") private WebElement backToProduct;
    @FindBy(xpath="(//div[@class=\"inventory_item_name\"])") private List<WebElement> productName;

    public CartPage(WebDriver driver)
    {
        PageFactory.initElements( driver, this);
    }
    public int numberOfContainers()
    {
        return containers.size();
    }
    public void clickOnRemove()
    {
        remove.click();
    }
    public double getProductPrice(int i)
    {
        String s=productPrice.get(i).getText();
        String p = s.substring(1);
        double price =Double.parseDouble(p);
        return price;
    }
    public boolean displayofSwaglabs()
    {
        return swaglabs.isDisplayed();
    }

    public void getProductName(int i)
    {
        productName.get(i).getText();
    }
    public void clickOnProductName(int i)
    {
        productName.get(i).click();
    }
    public void clickOnContinueShopping()
    {
        continueShopping.click();
    }
    public void clickOnChekOut()
    {
        chekout.click();
    }

    public void clickOnFunctionality()
    {
        functinality.click();
    }
    public void clickOnAllItems()
    {
        allItems.click();
    }
    public void clickOnAbout()
    {
        about.click();
    }
    public void clickOnLogOut()
    {
        logOut.click();
    }
    public void clickOnResetAppState()
    {
        resetAppState.click();
    }


}
