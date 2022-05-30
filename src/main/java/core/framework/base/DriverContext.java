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
    public static WebDriver Driver;
    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void WaitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver;

        ExpectedCondition<Boolean> jsLoad = webDriver ->  ((JavascriptExecutor) Driver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get Js ready state
        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if(!jsReady)
            wait.until(jsLoad);
        else
            Settings.Logs.Write("Page is ready !");
    }

    public static void WaitForVisible(final WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void WaitForTextVisible(final WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void WaitUntilTextDisplayed(final By by, String text){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(textDisplayed(by, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed (final By by, final String text){
        return webDriver -> webDriver.findElement(by).getText().contains(text);
    }

    public static void WaitForEnabled(final By by){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(webDriver -> webDriver.findElement(by).isEnabled());
    }

    public static void WaitForClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
