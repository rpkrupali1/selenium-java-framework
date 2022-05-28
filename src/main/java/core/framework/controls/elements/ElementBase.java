package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ElementBase extends ControlBase implements Element{
    public ElementBase(WebElement element) {
        super(element);
    }
}
