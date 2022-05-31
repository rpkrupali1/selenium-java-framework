package core.framework.utilities;

import com.aventstack.extentreports.ExtentTest;

public class Report {

    public Report(){

    }

    public void info(String message){
        System.out.println(message);
        ExtentReport.getTest().info(message);
    }
}
