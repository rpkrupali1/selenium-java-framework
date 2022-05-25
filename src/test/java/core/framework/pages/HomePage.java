package core.framework.pages;

import core.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//*[@id='nav-hamburger-menu']")
    private WebElement eleHamburgerMenu;

    @FindBy(how = How.XPATH, using = "//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]")
    private WebElement eleDepartment;

    @FindBy(how = How.XPATH, using = "//*[text()='Televisions']")
    private WebElement eleSubSection;

    @FindBy(how = How.XPATH, using = "//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]")
    private WebElement eleBrand;

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
