package core.framework.DriverManager;

import core.framework.base.BrowserType;
import core.framework.config.Settings;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriver implements Execution{
    @Override
    public RemoteWebDriver initiateBrowser(BrowserType browserType) {
        try
        {
            switch (browserType)
            {
                case Chrome:
                    var chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--ignore-ssl-errors=yes");
                    chromeOptions.addArguments("--ignore-certificate-errors");
                    return new RemoteWebDriver(new URL(Settings.RemoteDriverUrl), chromeOptions);
                case Firefox:
                    var firefoxOptions = new FirefoxOptions();
                    return new RemoteWebDriver(new URL(Settings.RemoteDriverUrl), firefoxOptions);
                case Edge:
                    var edgeOptions = new EdgeOptions();
                    return new RemoteWebDriver(new URL(Settings.RemoteDriverUrl), edgeOptions);
                default:
                    throw new Exception("Incorrect browser type, supported browsers types are chrome, firefox and edge");
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
