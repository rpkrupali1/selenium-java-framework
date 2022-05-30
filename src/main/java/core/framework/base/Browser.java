package core.framework.base;

import org.openqa.selenium.WebDriver;

//methods related to Browsers

public class Browser extends Base{
    private WebDriver _driver;
    public Browser(WebDriver driver) {
        _driver = driver;
    }
    public BrowserType type;
}

