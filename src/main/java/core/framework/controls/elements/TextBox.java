package core.framework.controls.elements;

import core.framework.controls.api.ImplementedBy;
import core.framework.controls.internals.Control;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {
    void EnterText(String text);
    String GetTextValue();
}
