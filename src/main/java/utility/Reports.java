package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

    public static ExtentReports createReports() {

        ExtentSparkReporter htmlreport = new ExtentSparkReporter("SawgLabs.html");
        ExtentReports report = new ExtentReports();
        report.attachReporter(htmlreport);
        report.setSystemInfo("Tested By", "Swapnil Bansode");
        report.setSystemInfo("Test Type", "Regression test");
        return report;
    }

}
