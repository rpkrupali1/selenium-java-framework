package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.base.DriverContext;
import core.framework.controls.elements.Element;
import core.framework.controls.elements.iElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
//    @FindBy(how = How.XPATH, using = "//*[@id='nav-hamburger-menu']")
//    private iElement eleHamburgerMenu;

//    @FindBy(how = How.XPATH, using = "//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]")
//    private iElement eleDepartment;

//    @FindBy(how = How.XPATH, using = "//*[text()='Televisions']")
//    private iElement eleSubSection;

//    @FindBy(how = How.XPATH, using = "//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]")
//    private iElement eleBrand;

    public Element eleDepartment() {
        return new Element(getElement("xpath","//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]"),"TV department","home page");
    }

    public Element eleSubSection() {
        return new Element(getElement("xpath","//*[text()='Televisions']"),"television","home page");
    }

    public Element eleBrand() {
        return new Element(getElement("xpath","//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]"),"brand","home page");
    }

    public Element eleHamburgerMenu() {
        return new Element(getElement("xpath","//*[@id='nav-hamburger-menu']"),"hamburger name","home page");
    }

    public void navigateToTelevision(){
        eleHamburgerMenu().click();
        eleDepartment().click();
        eleSubSection().click();
    }

    public void filterBySamsung(){
        eleBrand().click();
    }
}
