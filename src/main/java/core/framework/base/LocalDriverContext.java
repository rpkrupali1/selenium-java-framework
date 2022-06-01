package core.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverContext {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<RemoteWebDriver> remoteDriverThreadLocal = new ThreadLocal<>();
    public static WebDriver getLocalDriver(){
        return webDriverThreadLocal.get();
    }
    static void setWebDriverThreadLocal(WebDriver driver){
        webDriverThreadLocal.set(driver);
    }

    public static RemoteWebDriver getRemoteDriver(){
        return remoteDriverThreadLocal.get();
    }
    static void setRemoteDriverThreadLocalDriverThreadLocal(RemoteWebDriver driver){
        remoteDriverThreadLocal.set(driver);
    }
}
