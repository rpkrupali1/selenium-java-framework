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
        else
            Settings.Logs.Write("Page is ready !");
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
}
