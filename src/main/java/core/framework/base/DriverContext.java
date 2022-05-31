package core.framework.base;

import core.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class DriverContext extends Base{
//    public static WebDriver Driver;
//    public static Browser Browser;
//
//    public static void setDriver(WebDriver driver) {
//        Driver = driver;
//    }

    public static WebDriver getDriver(){
        return LocalDriverContext.getLocalDriver();
    }

    public static void maximize(){
        getDriver().manage().window().maximize();
        waitForPageToLoad();
    }

    public static void goToUrl(String url){
        getDriver().get(url);
        waitForPageToLoad();
    }

    public static void waitForPageToLoad(){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

        ExpectedCondition<Boolean> jsLoad = webDriver ->  ((JavascriptExecutor) getDriver())
                .executeScript("return document.readyState").toString().equals("complete");

        //Get Js ready state
        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if(!jsReady)
            wait.until(jsLoad);
    }

    public static void waitForVisible(final WebElement element){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForTextVisible(final WebElement element, String text){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilTextDisplayed(final By by, String text){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(textDisplayed(by, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed (final By by, final String text){
        return webDriver -> webDriver.findElement(by).getText().contains(text);
    }

    public static void waitForEnabled(final By by){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(webDriver -> webDriver.findElement(by).isEnabled());
    }

    public static void waitForClickable(WebElement element){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement findElement(String locatorType, String locatorID){
        var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                switch (locatorType) {
                    case "xpath":
                        return getDriver().findElement(By.xpath(locatorID));
                    case "id":
                        return getDriver().findElement(By.id(locatorID));
                    case "classname":
                        return getDriver().findElement(By.className(locatorID));
                    case "css":
                    case "cssselector":
                        return getDriver().findElement(By.cssSelector(locatorID));
                    case "linktext":
                        return getDriver().findElement(By.linkText(locatorID));
                    case "name":
                        return getDriver().findElement(By.name(locatorID));
                    case "partiallinktext":
                        return getDriver().findElement(By.partialLinkText(locatorID));
                    case "tagName":
                        return getDriver().findElement(By.tagName(locatorID));
                }
                Settings.Report.fail("locator type: " + locatorType + " is invalid, please correct your locator name in csv file");
                return null;
            }
        });
        return element;
    }
}
