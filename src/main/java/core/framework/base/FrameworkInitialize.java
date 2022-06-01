package core.framework.base;

import core.framework.DriverManager.Execution;
import core.framework.DriverManager.LocalDriver;
import core.framework.DriverManager.RemoteDriver;
import core.framework.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FrameworkInitialize extends Base {
    public void InitializeBrowser(BrowserType browserType){
        Execution execution = null;
        WebDriver driver = null;
//        switch (browserType)
//        {
//            case Chrome:{
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            }
//            case Firefox:{
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            }
//            case Edge:{
//                driver = new EdgeDriver();
//                break;
//            }
//            case Safari:{
//                driver = new SafariDriver();
//                break;
//            }
//        }

        if(Settings.ExecutionEnv.equals("remote")){
            execution = new RemoteDriver();
        }
        else
            execution = new LocalDriver();
        driver = execution.initiateBrowser(browserType);
        //set the driver
        //DriverContext.setDriver(driver);
        //set the browser
        //DriverContext.Browser = new Browser(driver);
        LocalDriverContext.setWebDriverThreadLocal(driver);
    }
    
}
