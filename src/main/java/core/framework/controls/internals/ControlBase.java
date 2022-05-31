package core.framework.controls.internals;

import core.framework.base.DriverContext;
import core.framework.config.Settings;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Coordinates;

import java.util.Arrays;
import java.util.List;

public class ControlBase implements Control{
    private final WebElement element;
    private final String elementName;
    private final String pageName;

    public ControlBase(WebElement element, String elementName, String pageName) {
        this.element= element;
        this.elementName = elementName;
        this.pageName = pageName;
    }

    @Override
    public void click() {
        waitForVisible();
        waitForClickable();
        element.click();
        DriverContext.waitForPageToLoad();
        Settings.Report.info("Clicked on element " + elementName + " in " + pageName);
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
        Settings.Logs.write("Entered text " + Arrays.toString(keysToSend) + " for element");
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
        String text = element.getText();
        Settings.Report.info("Text of an element " + elementName + " is <br />" + text + " within " + pageName);
        return text;
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

    ControlBase waitForVisible(){
        DriverContext.waitForVisible(getWrappedElement());
        return this;
    }

    ControlBase waitForClickable(){
        DriverContext.waitForClickable(getWrappedElement());
        return this;
    }
}
