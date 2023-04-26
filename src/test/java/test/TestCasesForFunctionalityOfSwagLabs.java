package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CartPage;
import pom.CheckOutPage;
import pom.ComplitionPage;
import pom.LoginPage;
import pom.Overview;
import pom.ProductDisplayPage;
import utility.Reports;

@Listeners(test.Listener.class)


public class TestCasesForFunctionalityOfSwagLabs extends Basetest {

    ExtentReports reports;
    ExtentTest test;

    @BeforeTest

    public void setupReports()
    {
        reports = Reports.createReports();
    }

    @DataProvider (name = "loginData")
    public Object [] [] loginTestData() throws EncryptedDocumentException, IOException
    {
        return new Object [] []
                {
                        {ExcelReader.reader1User(),ExcelReader.reader1Pass()},
                        {ExcelReader.read2User(),ExcelReader.read2Pass()},
                        {ExcelReader.read3User(),ExcelReader.read3Pass()},
                        {ExcelReader.read4User(),ExcelReader.read4Pass()}
                };
    }

    @BeforeMethod
    @Parameters("browser")
    public void BrowserLaunching(String browser) {
        driver = Browser.launchBrowser("browser");
    }

    @Test (dataProvider = "loginData",priority=0)
    public void verifyLogInFunctionality(String user, String pass) {

        test = reports.createTest("verifyLogInFunctionality()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(user);
        l.SendKeysOnPassword(pass);
        l.clickOnLogin();
    }

    @Test( priority=1)
    public void addProductOnCart() throws EncryptedDocumentException, IOException
    {
        test = reports.createTest("addProductOnCart()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(ExcelReader.reader1User());
        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();

        ProductDisplayPage productDisplayPage= new ProductDisplayPage(driver);

        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(productDisplayPage.numberOfContainers()>0);
        productDisplayPage.numberOfContainers();
        assertion.assertEquals(6, productDisplayPage.numberOfContainers());
        productDisplayPage.clickOnAddToCart(0);
        productDisplayPage.clickOnCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.numberOfContainers();
        assertion.assertEquals(1,cartPage.numberOfContainers());
        assertion.assertAll();


    }
    @Test( priority=2)
    public void removeProductFromCart() throws EncryptedDocumentException, IOException
    {
        test = reports.createTest("removeProductFromCart()");

        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(ExcelReader.reader1User());
        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();

        ProductDisplayPage productDisplayPage= new ProductDisplayPage(driver);
        productDisplayPage.displayedImeges(0);
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(true, productDisplayPage.displayedImeges(0));
        productDisplayPage.numberOfContainers();
        assertion.assertEquals(6, productDisplayPage.numberOfContainers());
        productDisplayPage.clickOnAddToCart(0);
        productDisplayPage.clickOnCart();

        CartPage cartPage = new CartPage(driver);
        assertion.assertEquals(1,cartPage.numberOfContainers());
        cartPage.clickOnContinueShopping();

        productDisplayPage.clickOnRemove(0);
        productDisplayPage.clickOnCart();

        assertion.assertEquals(0,cartPage.numberOfContainers());
        assertion.assertAll();
    }

    @Test( priority=3)
    public void addMultipleProductToCart() throws EncryptedDocumentException, IOException
    {
        test = reports.createTest("addMultipleProductToCart()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(ExcelReader.reader1User());
        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();


        ProductDisplayPage productDisplayPage= new ProductDisplayPage(driver);
        for(int i=0;i<3;i++) {
            productDisplayPage.displayedImeges(i);



            productDisplayPage.clickOnAddToCart(i);
            productDisplayPage.clickOnCart();

            CartPage cartPage = new CartPage(driver);

            cartPage.clickOnContinueShopping();

        }
        productDisplayPage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.numberOfContainers();

        Assert.assertTrue(cartPage.numberOfContainers()>0);

    }

    @Test( priority=4)
    public void RemoveMultipleProductsFromCart() throws EncryptedDocumentException, IOException
    {
        test = reports.createTest("addMultipleProductsRemoveFromCart()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(ExcelReader.reader1User());
        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();


        ProductDisplayPage productDisplayPage= new ProductDisplayPage(driver);
        for(int i=0;i<3;i++) {
            productDisplayPage.displayedImeges(i);



            productDisplayPage.clickOnAddToCart(i);
            productDisplayPage.clickOnCart();

            CartPage cartPage = new CartPage(driver);

            cartPage.clickOnContinueShopping();

        }
        productDisplayPage.clickOnCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.numberOfContainers();

        Assert.assertTrue(cartPage.numberOfContainers()>0);

        productDisplayPage.clickOnCart();


        for(int i=0;i<2;i++)
        {

            cartPage.clickOnContinueShopping();
            productDisplayPage.clickOnRemove(i);
            productDisplayPage.clickOnCart();
        }

        productDisplayPage.clickOnCart();

        Assert.assertEquals(1,cartPage.numberOfContainers());

    }

    @Test( priority=5)
    public void VerifyChekoutFunctionality() throws EncryptedDocumentException, IOException
    {
        test = reports.createTest("VerifyChekoutFunctionality()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        l.SendKeysOnUserName(ExcelReader.reader1User());
        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();


        ProductDisplayPage productDisplayPage= new ProductDisplayPage(driver);


        productDisplayPage.displayedImeges(0);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        productDisplayPage.clickOnAddToCart(0);
        productDisplayPage.clickOnAddToCart(1);

        CartPage cartPage = new CartPage(driver);
        productDisplayPage.clickOnCart();

        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(cartPage.numberOfContainers()>0);
        cartPage.clickOnChekOut();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.sendKeysOnFirstName(ExcelReader.readFirstName());
        checkOutPage.sendKeysOnlastname(ExcelReader.readLastName());
        checkOutPage.sendKeysOnPostleCode(ExcelReader.readPincode());
        checkOutPage.clickOnContinue();

        Overview overview = new Overview(driver);
        overview.getPaymentInfo();
        overview.getShippingInfo();
        double b = overview.ItemTotle(0)+overview.ItemTotle(1)+overview.getTax();
        System.out.println(b);
        assertion.assertEquals(b, overview.getTotle());

        overview.scrolInToViewFinish(driver);
        overview.clickOnFinish();

        ComplitionPage complitionPage = new ComplitionPage(driver);

        assertion.assertTrue(complitionPage.getTitle());
        complitionPage.clickOnBackHome();

        assertion.assertAll();


    }

    @AfterMethod
    public void getTestResult(ITestResult result)
    {
        if(result.getStatus()== ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
        }
        else if (result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getName());
        }
        else if(result.getStatus()==ITestResult.SKIP)
        {
            test.log(Status.SKIP,result.getName());
        }

    }

    @AfterTest
    public void publishReports()
    {
        reports.flush();
    }

}