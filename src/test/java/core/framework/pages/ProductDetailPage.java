package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='About this item']")
    private Element eleAboutThisHeader;

    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='About this item']/following-sibling::ul")
    private Element eleProductDescription;

    public boolean isAboutThisHeaderDisplayed(){
        return eleAboutThisHeader.isDisplayed();
    }

    public String getProductDetails(){
        return eleProductDescription.getText();
    }

}
