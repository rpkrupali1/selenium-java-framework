package core.framework.DriverManager;

import core.framework.base.BrowserType;
import core.framework.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DockerDriver implements Execution{
    @Override
    public WebDriver initiateBrowser(BrowserType browserType) {
        try
        {
            WebDriver driver = null;
            //WebDriverManager wdm;
            switch (browserType)
            {
                case Chrome:
                    var chromeDriverPath = System.getProperty("chromeDriverPath");
                    if(chromeDriverPath==null || chromeDriverPath=="")
                        Settings.Report.exception(new Exception("Chrome driver path is null or empty"));
                    var chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--ignore-ssl-errors=yes");
                    chromeOptions.addArguments("--ignore-certificate-errors");
                    chromeOptions.setHeadless(true);
                    //wdm = WebDriverManager.chromedriver().capabilities(chromeOptions).browserInDocker().enableVnc().enableRecording();
                    System.setProperty("webdriver.chrome.driver",chromeDriverPath);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case Firefox:
                    //wdm = WebDriverManager.firefoxdriver().browserInDocker().enableVnc().enableRecording();
                    break;
                case Edge:
                    //wdm = WebDriverManager.edgedriver().browserInDocker().enableVnc().enableRecording();
                    break;
                default:
                    throw new Exception("Incorrect browser type, supported browsers types are chrome, firefox and edge");
            }
            //driver = wdm.create();
            //Settings.Report.info("noVnc url: " + wdm.getDockerNoVncUrl());
            //System.out.println("noVnc url: " + wdm.getDockerNoVncUrl());
            //Settings.Report.info("recording path: " + wdm.getDockerRecordingPath());
            //System.out.println("recording path: " + wdm.getDockerRecordingPath());
            return driver;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
