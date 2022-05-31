package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class Element extends ControlBase {
    public Element(WebElement element, String elementName, String pageName) {
        super(element, elementName, pageName);
    }

}
