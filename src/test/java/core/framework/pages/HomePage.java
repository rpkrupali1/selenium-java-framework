package core.framework.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@id='nav-hamburger-menu']")
    private Element eleHamburgerMenu;

    @FindBy(how = How.XPATH, using = "//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]")
    private Element eleDepartment;

    @FindBy(how = How.XPATH, using = "//*[text()='Televisions']")
    private Element eleSubSection;

    @FindBy(how = How.XPATH, using = "//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]")
    private Element eleBrand;

    public void navigateToTelevision() throws InterruptedException {
        eleHamburgerMenu.click();
        Thread.sleep(1000);
        eleDepartment.click();
        Thread.sleep(1000);
        eleSubSection.click();
        Thread.sleep(1000);
    }

    public void filterBySamsung() throws InterruptedException {
        eleBrand.click();
        Thread.sleep(1000);
    }
}
