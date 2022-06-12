package core.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import core.framework.config.Settings;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    private static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();
    private static String reportFileName = "AutomationReport";
    private static ZonedDateTime date = ZonedDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    private static String fileNameFormat = date.format((formatter));

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

    public static ExtentReports getInstance(){
        if(extent==null) {
            //Set HTML reporting file location
            var outputDirectory = new File(System.getProperty("user.dir") + Settings.TestOutputPath);
            if(!outputDirectory.exists())
                outputDirectory.mkdir();
            createInstance(outputDirectory + "/" + reportFileName + fileNameFormat  + ".html" );
        }
        return extent;
    }

    public static void setTest(ExtentTest test){
        threadLocalTest.set(test);
    }

    public static ExtentTest getTest(){
        return threadLocalTest.get();
    }
}
