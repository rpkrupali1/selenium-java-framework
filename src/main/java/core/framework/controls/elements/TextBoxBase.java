package core.framework.controls.elements;

import core.framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class TextBoxBase extends ControlBase implements TextBox  {
    public TextBoxBase(WebElement element, String elementName,String pageName) {
        super(element,elementName,pageName);
    }

    @Override
    public void EnterText(String text) {
        getWrappedElement().sendKeys(text);
    }

    @Override
    public String GetTextValue() {
        return getWrappedElement().getText();
    }
}
