package core.framework.tests;

import core.framework.base.BrowserType;
import core.framework.base.DriverContext;
import core.framework.base.FrameworkInitialize;
import core.framework.config.ConfigReader;
import core.framework.config.Settings;
import core.framework.pages.HomePage;
import core.framework.pages.ProductDetailPage;
import core.framework.pages.ProductListingPage;
import core.framework.utilities.ExtentReport;

import core.framework.utilities.Report;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class amazonTest extends FrameworkInitialize {
    @BeforeTest
    public void initialize() throws IOException {
        ConfigReader.PopulateSettings();
        Settings.Report = new Report();
        Settings.ExtentReports = ExtentReport.getInstance();
        var node = Settings.ExtentReports.createTest("Test1");
        ExtentReport.setTest(node);
        InitializeBrowser(BrowserType.Chrome);
        Settings.Logs.write("Test Started");
        DriverContext.maximize();
        DriverContext.goToUrl("https://www.amazon.in/");
        Settings.Logs.write("Navigated to url https://www.amazon.in/");
    }

    @Test
    public void shoppingTest() {
        //navigate to television and filter by brand
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage.As(HomePage.class).navigateToTelevision();
        CurrentPage.As(HomePage.class).filterBySamsung();

        //sort by price high to low and select second product listing
        CurrentPage = GetInstance(ProductListingPage.class);
        CurrentPage.As(ProductListingPage.class).sortByPriceHighToLow();
        String originalWindow = DriverContext.getDriver().getWindowHandle();
        CurrentPage = CurrentPage.As(ProductListingPage.class).clickOnSecondProductListing();

        // Loop through until we find a new window handle
        for (String windowHandle : DriverContext.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverContext.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(CurrentPage.As(ProductDetailPage.class).isAboutThisHeaderDisplayed(),true);
        System.out.println(CurrentPage.As(ProductDetailPage.class).getProductDetails());
    }

    @AfterTest
    public void endTest(){
        DriverContext.getDriver().quit();
        Settings.ExtentReports.flush();
    }
}
