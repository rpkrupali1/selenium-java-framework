package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductListingPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//span[*[text()='Sort by:']]")
    private Element eleSortBy;

    @FindBy(how = How.XPATH, using = "//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']")
    private Element elePriceHighToLow;

    @FindBy(how = How.XPATH, using = "//*[@data-component-type='s-search-result'][2]")
    private Element eleSecondProduct;

    public void sortByPriceHighToLow() throws InterruptedException {
        eleSortBy.click();
        Thread.sleep(1000);
        elePriceHighToLow.click();
        Thread.sleep(1000);
    }

    public ProductDetailPage clickOnSecondProductListing() throws InterruptedException {
        eleSecondProduct.click();
        Thread.sleep(1000);
        return GetInstance(ProductDetailPage.class);
    }
}
