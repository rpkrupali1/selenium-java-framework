package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.iElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='About this item']")
    private iElement eleAboutThisHeader;

    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='About this item']/following-sibling::ul")
    private iElement eleProductDescription;

    public boolean isAboutThisHeaderDisplayed(){
        return eleAboutThisHeader.isDisplayed();
    }

    public String getProductDetails(){
        return eleProductDescription.getText();
    }

}
