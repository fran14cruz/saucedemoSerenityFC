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
import java.util.stream.Collectors;

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

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    WebElementFacade cartIcon;

    @FindBy(xpath = "//*[@class='cart_item_label']/a/div")
    List<WebElementFacade> cartItemsLabelList;

    @FindBy(xpath = "//*[@class='cart_item_label']/div[1]")
    List<WebElementFacade> cartItemsDescList;

    @FindBy(xpath = "//*[@class='cart_item_label']/div[2]/div")
    List<WebElementFacade> cartItemsPriceList;

    @FindBy(xpath = "//*[@class='cart_quantity']")
    List<WebElementFacade> cartItemsQuantList;

    @FindBy(xpath = "//*[@id='checkout']")
    WebElementFacade checkoutButton;

    @FindBy(xpath = "//*[@id='first-name']")
    WebElementFacade firstNameCheckout;

    @FindBy(xpath = "//*[@id='last-name']")
    WebElementFacade lastNameCheckout;

    @FindBy(xpath = "//*[@id='postal-code']")
    WebElementFacade postalCodeCheckout;

    @FindBy(xpath = "//*[@id='continue']")
    WebElementFacade continueButtonCheckout;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    List<WebElementFacade> checkoutPricesList;

    @FindBy(xpath = "//*[@class='summary_tax_label']")
    WebElementFacade checkoutTaxAmount;

    @FindBy(xpath = "//*[@class='summary_info_label summary_total_label']")
    WebElementFacade checkoutTotalAmount;

    @FindBy(xpath = "//*[@id='finish']")
    WebElementFacade finishButtonCheckout;

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    WebElementFacade successMessageCheckout;

    @FindBy(xpath = "//*[@id='back-to-products']")
    WebElementFacade backHomeButtonCheckout;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[2]")
    WebElementFacade paymentInfoText;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[4]")
    WebElementFacade shippingInfoText;

    @FindBy(xpath = "//*[@class='summary_subtotal_label']")
    WebElementFacade checkoutSubtotalAmount;

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

    // SCENARIO 4
    public void goToCheckout() {
        // go to cart
        cartIcon.click();

        // save cart info to Serenity Report
        List<String> detailsList = new ArrayList<>();
        for (int i=0; i<cartItemsLabelList.size(); i++) {
            detailsList.add("Item #" + i + ": " + cartItemsLabelList.get(i).getText() + "\n" +
                    "Description: " + cartItemsDescList.get(i).getText() + "\n" +
                    "Quantity: " + cartItemsQuantList.get(i).getText() + ", Price: " + cartItemsPriceList.get(i).getText());
        }
        String details = detailsList.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("\n"));
        Serenity.recordReportData().withTitle("Items in cart").andContents(details);

        // finally, click on Checkout
        checkoutButton.click();
    }

    public void fillUpPersonalInfo(String firstName, String lastName, String postalCode) {
        firstNameCheckout.sendKeys(firstName);
        lastNameCheckout.sendKeys(lastName);
        postalCodeCheckout.sendKeys(postalCode);
        // hit Continue
        continueButtonCheckout.click();
    }

    public void verifyCorrectTotalPrice() {
        float amountWithoutTax = 0.0F;
        for (WebElementFacade itemPrice : checkoutPricesList) {
            amountWithoutTax += Float.parseFloat(itemPrice.getText().replace("$", ""));
        }

        // Total Price is amountWithoutTax + tax
        float totalPrice = amountWithoutTax + Float.parseFloat(checkoutTaxAmount.getText().replace("Tax: $", ""));

        Assert.assertTrue(totalPrice == Float.parseFloat(checkoutTotalAmount.getText().replace("Total: $", "")));
        String details = "Expected Total Price is: $" + totalPrice + "\n" +
                "Total Price displayed on Checkout page is: " + checkoutTotalAmount.getText();
        Serenity.recordReportData().withTitle("Total Price (tax included) on checkout").andContents(details);
    }

    // SCENARIO 5
    public void saveCheckoutOverviewInfo() {
        // save Checkout overview info to Serenity Report
        String details = "Payment Information: " + paymentInfoText.getText() + "\n" +
                "Shipping Information: " + shippingInfoText.getText() + "\n" +
                "Item Subtotal: " + checkoutSubtotalAmount.getText() + "\n" +
                "Tax: " + checkoutTaxAmount.getText() + "\n" +
                "Grand " + checkoutTotalAmount.getText();
        Serenity.recordReportData().withTitle("Checkout overview information").andContents(details);
    }

    public void clickFinishCheckoutButton() {
        finishButtonCheckout.click();
    }

    public void viewCheckoutSuccess() {
        Assert.assertTrue(successMessageCheckout.isDisplayed());
        Assert.assertTrue(backHomeButtonCheckout.isDisplayed());

        String details = "Message displayed after completing checkout: " + successMessageCheckout.getText();
        Serenity.recordReportData().withTitle("Success message after checkout").andContents(details);
    }

}
