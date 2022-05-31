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

    public static Element eleDepartment() {
        return new Element(getElement("xpath","//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]"),"TV department","home page");
    }

    public static Element eleSubSection() {
        return new Element(getElement("xpath","//*[text()='Televisions']"),"television","home page");
    }

    public static Element eleBrand() {
        return new Element(getElement("xpath","//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]"),"brand","home page");
    }

    public static Element eleHamburgerMenu() {
        return new Element(getElement("xpath","//*[@id='nav-hamburger-menu']"),"hamburger name","home page");
    }

    public void navigateToTelevision() throws InterruptedException {
        eleHamburgerMenu().click();
        Thread.sleep(1000);
        eleDepartment().click();
        //Thread.sleep(1000);
        eleSubSection().click();
        //Thread.sleep(1000);
    }

    public void filterBySamsung() throws InterruptedException {
        eleBrand().click();
        //Thread.sleep(1000);
    }
}
