package core.framework.base;

import core.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Base {

    private static String elementName;
    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance)
    {
        try
        {
            return (TPage)this;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return null;
    }

    protected static WebElement getElement(String locatorType,String locatorValue){
        try{
           return DriverContext.findElement(locatorType,locatorValue);
        }
        catch (Exception e){
            e.printStackTrace();
            Settings.Report.exception(e);
            return null;
        }
    }


}
