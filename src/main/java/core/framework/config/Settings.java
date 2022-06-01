package core.framework.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import core.framework.utilities.Logs;
import core.framework.utilities.Report;

public class Settings {
    public static String LogPath;
    public static Logs Logs;
    public static Report Report;

    public static ExtentReports ExtentReports;

    public static ExtentTest ExtentTest;
    public static String ReportPath;
}
