package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;
import core.framework.controls.elements.iElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductListingPage extends BasePage {
//    @FindBy(how = How.XPATH, using = "//span[*[text()='Sort by:']]")
//    private iElement eleSortBy;
//
//    @FindBy(how = How.XPATH, using = "//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']")
//    private iElement elePriceHighToLow;
//
//    @FindBy(how = How.XPATH, using = "//*[@data-component-type='s-search-result'][2]")
//    private iElement eleSecondProduct;

    public Element eleSortBy() {
        return new Element(getElement("xpath","//span[*[text()='Sort by:']]"),"Sort by dropdown","product listing page");
    }

    public Element elePriceHighToLow() {
        return new Element(getElement("xpath","//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']"),"Price high to low option","product listing page");
    }

    public Element eleSecondProduct() {
        return new Element(getElement("xpath","//*[@data-component-type='s-search-result'][2]"),"Second product from search listing","product listing page");
    }
    public void sortByPriceHighToLow() throws InterruptedException {
        eleSortBy().click();
        //Thread.sleep(1000);
        elePriceHighToLow().click();
        //Thread.sleep(1000);
    }

    public ProductDetailPage clickOnSecondProductListing() throws InterruptedException {
        eleSecondProduct().click();
        //Thread.sleep(1000);
        return GetInstance(ProductDetailPage.class);
    }
}
