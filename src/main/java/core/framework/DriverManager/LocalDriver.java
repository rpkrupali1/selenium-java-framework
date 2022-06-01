package core.framework.DriverManager;

import core.framework.base.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalDriver implements Execution{
    @Override
    public WebDriver initiateBrowser(BrowserType browserType) {
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
        return driver;
    }
}
