package core.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FrameworkInitialize extends Base {
    public void InitializeBrowser(BrowserType browserType){
        WebDriver driver = null;
        switch (browserType)
        {
            case Chrome:{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case Firefox:{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case Edge:{
                driver = new EdgeDriver();
                break;
            }
            case Safari:{
                driver = new SafariDriver();
                break;
            }
        }
        //set the driver
        DriverContext.setDriver(driver);
        //set the browser
        DriverContext.Browser = new Browser(driver);
    }
    
}
