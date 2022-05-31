package core.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    private static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();
    private static String reportFileName = "AutomationReport.html";

    private static ExtentReports createInstance(String fileName){
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("AutomationReport");
        extent.attachReporter(spark);
        extent.setSystemInfo("os",System.getProperty("os.name"));
        extent.setSystemInfo("UserName",System.getProperty("user.name"));
        extent.setSystemInfo("JavaVersion",System.getProperty("java.version"));
        return extent;
    }

    private static ExtentReports getInstance(){
        if(extent==null) {
            //Set HTML reporting file location
            String outputDirectory = System.getProperty("user.dir") + "/src/test/java/reports/report.html";
            createInstance(outputDirectory);
        }
        return extent;
    }

    public static void setTest(ExtentTest test){
        threadLocalTest.set(test);
    }

    private static ExtentTest getTest(){
        return threadLocalTest.get();
    }
}
