package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends PageObject {

    //private final WebDriver driver;
    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    WebElementFacade burgerMenu;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    WebElementFacade aboutTab;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div/span/select")
    WebElementFacade filterDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
    List<WebElementFacade> addToCartButtonsList;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    WebElementFacade cartProductNumber;


//    public ProductsPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    // SCENARIO 2
    public void clickOnMenu() {
        burgerMenu.click();
    }

    public void clickOnAbout() {
        aboutTab.click();
    }

    public void backToProductsPage() {
        //driver.navigate().back();
    }

    // SCENARIO 3
    public void filterProducts(String productFilter) {
        filterDropdown.click();
        // Filter by Name(A to Z) by default
        String filterChoice = "//*[@id='header_container']/div[2]/div/span/select/option[1]";
        // Switch can be implemented for each filter
        if (productFilter.equals("priceLowToHigh")) {
            filterChoice = "//*[@id='header_container']/div[2]/div/span/select/option[3]";
        }
        WebElement priceLowToHighFilter = withTimeoutOf(2, TimeUnit.SECONDS).find(By.xpath(filterChoice));
        priceLowToHighFilter.click();
    }

    public void addExpensiveProductsToCart(String productNumber) {
//        List<Float> pricesListDecimal = new ArrayList<>();
//        for (WebElementFacade price : pricesList) {
//            pricesListDecimal.add(Float.parseFloat(price.getText().replace("$", "")));
//        }
        // The four most expensive are the four last items in the list
        int addToCartButtonsListSize = addToCartButtonsList.size();
        int productNumberInt = Integer.parseInt(productNumber);
        int startItemIndex = (productNumberInt > addToCartButtonsListSize) ? addToCartButtonsListSize : (addToCartButtonsListSize - productNumberInt);
        List<WebElementFacade> addToCartItems = addToCartButtonsList.subList(startItemIndex, addToCartButtonsListSize);

        // Add items to the cart
        for (WebElementFacade cartItem : addToCartItems) {
            cartItem.click();
        }
    }

    public void viewProductNumberOnCart(String productNumber) {
        Assert.assertEquals(Integer.parseInt(productNumber), Integer.parseInt(cartProductNumber.getText()));
        String details = "Number of products added to the cart is: " + cartProductNumber.getText() + "\n" +
                "The expected number of products is: " + productNumber;
        Serenity.recordReportData().withTitle("Products number on cart").andContents(details);
    }

}
