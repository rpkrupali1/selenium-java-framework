package core.framework.controls.internals;

import core.framework.base.DriverContext;
import core.framework.config.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.util.Arrays;
import java.util.List;

public class ControlBase implements Control{
    private final WebElement element;

    public ControlBase(WebElement element) {
        this.element= element;
    }

    @Override
    public void click() {
        DriverContext.WaitForClickable(element);
        element.click();
        DriverContext.WaitForPageToLoad();
        Settings.Logs.Write("Clicked on element");
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
        Settings.Logs.Write("Entered text " + Arrays.toString(keysToSend) + " for element");
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public Coordinates getCoordinates() {
        return null;
    }
}
