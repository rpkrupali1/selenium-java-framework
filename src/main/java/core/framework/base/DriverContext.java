package core.framework.base;

import org.openqa.selenium.WebDriver;

public class DriverContext extends Base{
    public static WebDriver Driver;
    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }
}
