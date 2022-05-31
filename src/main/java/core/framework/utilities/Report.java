package core.framework.utilities;

import core.framework.config.Settings;

public class Report {

    public Report(){
        Settings.Logs = new Logs();
        Settings.Logs.CreateLogFile();
    }

    public void info(String message){
        System.out.println(message);
        ExtentReport.getTest().info(message);
        Settings.Logs.write(message);
    }

    public void pass(String message){
        System.out.println(message);
        ExtentReport.getTest().pass(message);
        Settings.Logs.write(message);
    }

    public void fail(String message){
        System.out.println(message);
        ExtentReport.getTest().fail(message);
        Settings.Logs.write(message);
    }

    public void warn(String message){
        System.out.println(message);
        ExtentReport.getTest().warning(message);
        Settings.Logs.write(message);
    }

    public void exception(Exception e){
        System.out.println(e);
        ExtentReport.getTest().fail(e);
        Settings.Logs.write(e.getMessage());
    }
}
