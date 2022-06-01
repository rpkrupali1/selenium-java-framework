package core.framework.controls.internals;

import core.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
    ControlBase waitForVisible();
    ControlBase scrollToElement();

    ControlBase waitForClickable();
}
