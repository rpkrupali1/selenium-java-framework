package core.framework.DriverManager;

import core.framework.base.BrowserType;
import org.openqa.selenium.WebDriver;

public interface Execution {
    public WebDriver initiateBrowser(BrowserType browserType);
}
