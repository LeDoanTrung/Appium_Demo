package test.apiLearning;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class ExtentReportDemo {

    protected ExtentReports extent;
    protected ExtentSparkReporter spark;

    @BeforeSuite
    public void reportSetUp(){
            File reportsDir = new File("reports");
            if (!reportsDir.exists()) {
                reportsDir.mkdirs();
            }
        extent= new ExtentReports();
        spark= new ExtentSparkReporter("reports/report.html");
        extent.attachReporter(spark);
        extent.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
    }

    @AfterSuite
    public void reportTearDown(){
        extent.flush();
    }


}
