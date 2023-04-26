package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {

    @FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement  paymentInfo;
    @FindBy(xpath = "//div[text()='Free Pony Express Delivery!']") private WebElement shippingInfo ;
    @FindBy(xpath = "//div[@class=\"summary_subtotal_label\"]") private WebElement itemTotle ;
    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]") private WebElement tax ;
    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]") private WebElement  totle;
    @FindBy(xpath = "//button[@name=\"cancel\"]") private WebElement cancle ;
    @FindBy(xpath = "//button[@id=\"finish\"]") private WebElement  finish;
    @FindBy(xpath="//div[@class=\"inventory_item_price\"]") private List<WebElement> productPrice;

    public Overview(WebDriver driver)
    {
        PageFactory.initElements( driver,this);
    }

    public void getPaymentInfo()
    {
        System.out.println(paymentInfo.getText());
    }
    public void getShippingInfo()
    {
        System.out.println(shippingInfo.getText());
    }
    public double ItemTotle(int i)

    {
        String s=productPrice.get(i).getText();
        String p = s.substring(1);
        double price =Double.parseDouble(p);
        System.out.println(price);
        return price;
    }

    public double getTax()
    {
        String s = tax.getText();
        String p = s.substring(6);
        double price =Double.parseDouble(p);
        System.out.println(price);
        return price;
    }

    public double getTotle()
    {
        String s = totle.getText();
        String p = s.substring(1);
        double amount =Double.parseDouble(p);
        System.out.println(amount);
        return amount;
    }

    public void scrolInToViewFinish(WebDriver driver)
    {
        Actions a=new Actions(driver);
        a.moveToElement(finish);
    }

    public void clickOnCancle()
    {
        cancle.click();
    }

    public void clickOnFinish()
    {
        finish.click();
    }




}