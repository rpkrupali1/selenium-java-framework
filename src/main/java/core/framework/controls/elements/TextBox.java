package core.framework.controls.elements;

import core.framework.controls.api.ImplementedBy;

@ImplementedBy(TextBoxBase.class)
public interface TextBox {
    void EnterText(String text);
    String GetTextValue();
}
