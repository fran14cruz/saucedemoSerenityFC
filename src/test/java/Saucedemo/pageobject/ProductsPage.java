package Saucedemo.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends PageObject {

    //private final WebDriver driver;
    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    WebElementFacade burgerMenu;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    WebElementFacade aboutTab;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div/span/select")
    WebElementFacade filterDropdown;



//    public ProductsPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public void clickOnMenu() {
        burgerMenu.click();
    }

    public void clickOnAbout() {
        aboutTab.click();
    }

    public void backToProductsPage() {
        //driver.navigate().back();
    }

}
