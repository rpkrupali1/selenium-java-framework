package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class CheckboxBase extends ControlBase implements Checkbox{
    public CheckboxBase(WebElement element) {
        super(element);
    }
}
