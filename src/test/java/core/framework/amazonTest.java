package core.framework;

import core.framework.base.DriverContext;
import core.framework.pages.HomePage;
import core.framework.pages.ProductDetailPage;
import core.framework.pages.ProductListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonTest {
    @BeforeTest
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        DriverContext.Driver = new ChromeDriver();
        DriverContext.Driver.get("https://www.amazon.in/");
    }

    @Test
    public void shoppingTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Televisions']")).click();
        Thread.sleep(1000);
        // WebElement elBrands = driver.findElement(By.xpath("xpathExpression"));
        driver.findElement(By.xpath(
                "//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[*[text()='Sort by:']]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']")).click();
        Thread.sleep(1000);
        // get original windows
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@data-component-type='s-search-result'][2]")).click();
        Thread.sleep(1000);

        // Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='About this item']")).isDisplayed());
        System.out
                .println(driver.findElement(By.xpath("//h1[normalize-space()='About this item']/following-sibling::ul"))
                        .getText());

        driver.quit();
    }

    @Test
    public void shoppingTest2() throws InterruptedException {
        Thread.sleep(1000);
        //navigate to television and filter by brand
        HomePage homePage = new HomePage();
        homePage.navigateToTelevision();
        homePage.filterBySamsung();

        //sort by price high to low and select second product listing
        ProductListingPage productListingPage = new ProductListingPage();
        productListingPage.sortByPriceHighToLow();
        String originalWindow = DriverContext.Driver.getWindowHandle();
        ProductDetailPage productDetailPage = (ProductDetailPage) productListingPage.clickOnSecondProductListing();

        // Loop through until we find a new window handle
        for (String windowHandle : DriverContext.Driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                DriverContext.Driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(productDetailPage.isAboutThisHeaderDisplayed(),true);
        System.out.println(productDetailPage.getProductDetails());

        DriverContext.Driver.quit();
    }
}
