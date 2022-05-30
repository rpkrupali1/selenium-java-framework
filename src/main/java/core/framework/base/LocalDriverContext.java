package core.framework.base;

import org.openqa.selenium.WebDriver;

public class LocalDriverContext {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    public static WebDriver getLocalDriver(){
        return webDriverThreadLocal.get();
    }
    static void setWebDriverThreadLocal(WebDriver driver){
        webDriverThreadLocal.set(driver);
    }
}
