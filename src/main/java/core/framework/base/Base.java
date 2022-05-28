package core.framework.base;

import core.framework.controls.api.ControlFactory;
import org.openqa.selenium.support.PageFactory;

public class Base {
    public static BasePage CurrentPage;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page){
        //Object obj = PageFactory.initElements(DriverContext.Driver,page);
        //Custom factory control
        Object obj = ControlFactory.initElements(DriverContext.Driver,page);
        return page.cast(obj);
    }
}
