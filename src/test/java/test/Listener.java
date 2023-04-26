package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;


public class Listener extends Basetest implements ITestListener {

    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Starts :-" +result.getName());
    }
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Pass :-" + result.getName());
    }
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped :-" +result.getName());
    }
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Fail :-" +result.getName());
        try
        {
            Screenshot.shot(driver,result.getName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void onStart() {
        System.out.println("All Tests Started");
    }
    public void onFinish()
    {
        System.out.println("All Tests Finished");
    }

}
