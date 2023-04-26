package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDisplayPage {

    @FindBy(xpath="//select[@class=\"product_sort_container\"]") private  WebElement filter ;
    @FindBy(xpath="//img[@class=\"inventory_item_img\"]") private List<WebElement> imeges ;
    @FindBy(xpath="//div[@class=\"inventory_item_description\"]") private List<WebElement> containers ;
    @FindBy(xpath="//button[@class=\"btn btn_primary btn_small btn_inventory\"]") private List<WebElement> addToCarts ;
    @FindBy(xpath="//button[@class=\"btn btn_secondary btn_small btn_inventory\"]") private List<WebElement> remove ;
    @FindBy(xpath="//a[@class=\"shopping_cart_link\"]") private WebElement cart;
    @FindBy(xpath="//div[@class=\"inventory_item_price\"]") private List<WebElement> productPrice ;
    @FindBy(xpath="//button[@id=\"react-burger-menu-btn\"]") private WebElement functinality;
    @FindBy(xpath="(//a[@class=\"bm-item menu-item\"])[1]") private WebElement allItems;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[2]") private WebElement about;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[3]") private WebElement logOut;
    @FindBy(xpath="(//a[@class=\\\"bm-item menu-item\\\"])[4]") private WebElement resetAppState;

    public ProductDisplayPage(WebDriver driver)
    {
        PageFactory.initElements( driver,this);
    }

    public  void clickOnFilter(int i)
    {
        Select s= new Select(filter);
        s.selectByIndex(i);
    }
    public boolean displayedImeges(int i)
    {
        boolean b= imeges.get(i).isDisplayed();
        return b;
    }
    public int numberOfContainers()
    {
        return containers.size();

    }
    public void clickOnContainer(int i)
    {
        containers.get(i).click();
    }
    public void clickOnAddToCart(int i)
    {
        addToCarts.get(i).click();
    }
    public void clickOnRemove(int i)
    {
        remove.get(i).click();
    }
    public void clickOnCart()
    {
        cart.click();
    }
    public double getProductPrice(int i)
    {
        String s=productPrice.get(i).getText();
        String p = s.substring(1);
        double price =Double.parseDouble(p);
        return price;
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
