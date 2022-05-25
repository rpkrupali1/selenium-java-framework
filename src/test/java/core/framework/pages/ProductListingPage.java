package core.framework.pages;

import core.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductListingPage extends BasePage {

    public ProductListingPage() {
        super();
    }
    @FindBy(how = How.XPATH, using = "//span[*[text()='Sort by:']]")
    private WebElement eleSortBy;

    @FindBy(how = How.XPATH, using = "//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']")
    private WebElement elePriceHighToLow;

    @FindBy(how = How.XPATH, using = "//*[@data-component-type='s-search-result'][2]")
    private WebElement eleSecondProduct;

    public void sortByPriceHighToLow() throws InterruptedException {
        eleSortBy.click();
        Thread.sleep(1000);
        elePriceHighToLow.click();
        Thread.sleep(1000);
    }

    public BasePage clickOnSecondProductListing() throws InterruptedException {
        eleSecondProduct.click();
        Thread.sleep(1000);
        return new ProductDetailPage();
    }
}
