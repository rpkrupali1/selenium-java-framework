package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ElementBase extends ControlBase implements iElement {
    public ElementBase(WebElement element,String elementName,String pageName) {
        super(element,elementName,pageName);
    }

}
