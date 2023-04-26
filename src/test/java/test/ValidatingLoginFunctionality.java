package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.LoginPage;
import pom.ProductDisplayPage;
import utility.Exelsheet;
import utility.Reports;

@Listeners(test.Listener.class)
public class ValidatingLoginFunctionality extends Basetest {
    ExtentReports report;
    ExtentTest test;
    @BeforeClass
    public void setUpReports()
    {
        report = Reports.createReports();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void BrowserLaunching(String browser)
    {
        driver=Browser.launchBrowser("browser");
    }

    @Test(priority=1)
    public void verifyLoginWithstandard_user() throws EncryptedDocumentException, IOException
    {
        test = report.createTest("verifyLoginWithstandard_user()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        l.SendKeysOnUserName(ExcelReader.reader1User());

        l.SendKeysOnPassword(ExcelReader.reader1Pass());
        l.clickOnLogin();
        ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver);
        Assert.assertEquals(6, productDisplayPage.numberOfContainers());
    }

    @Test(priority=2)

    public void verifyLoginWithlocked_out_user() throws EncryptedDocumentException, IOException
    {
        test = report.createTest("verifyLoginWithlocked_out_user()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        l.SendKeysOnUserName(ExcelReader.read2User());

        l.SendKeysOnPassword(ExcelReader.read2Pass());
        l.clickOnLogin();
        Assert.assertTrue(l.visualisationOfErrorMsg());
    }

    @Test(priority=3)

    public void verifyLoginWithproblem_user() throws EncryptedDocumentException, IOException
    {
        test = report.createTest("verifyLoginWithproblem_user()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        l.SendKeysOnUserName(ExcelReader.read3User());

        l.SendKeysOnPassword(ExcelReader.read3Pass());
        l.clickOnLogin();
        ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver);
        Assert.assertEquals(true,productDisplayPage.displayedImeges(0)==productDisplayPage.displayedImeges(1));
    }

    @Test(priority=4,timeOut=1200)


    public void verifyLoginWithperformance_glitch_user() throws EncryptedDocumentException, IOException
    {
        test = report.createTest("verifyLoginWithperformance_glitch_user()");
        LoginPage l= new LoginPage( driver);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        l.SendKeysOnUserName(ExcelReader.read4User());

        l.SendKeysOnPassword(ExcelReader.read4Pass());
        l.clickOnLogin();

    }

    @AfterMethod
    public void getTestResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            test.log(Status.PASS, result.getName());
        }
        if(result.getStatus()==ITestResult.SKIP)
        {
            test.log(Status.SKIP, result.getName());
        }
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, result.getName());
        }
    }
    @AfterTest
    public void publishReports()
    {
        report.flush();
    }

}
