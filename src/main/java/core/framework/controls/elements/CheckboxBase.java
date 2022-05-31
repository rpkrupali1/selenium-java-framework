package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class CheckboxBase extends ControlBase implements iCheckbox {
    public CheckboxBase(WebElement element, String elementName,String pageName) {
        super(element,elementName,pageName);
    }
}
