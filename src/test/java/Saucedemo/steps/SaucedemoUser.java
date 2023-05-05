package Saucedemo.steps;

import Saucedemo.pageobject.MainPage;
import Saucedemo.pageobject.ProductsPage;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class SaucedemoUser extends ScenarioActor {
    String actor;

    @Steps(shared = true)
    MainPage mainPage;

    @Steps(shared = true)
    ProductsPage productsPage;

    // SCENARIO 1
    public void navigatesToSaucedemo() {
        mainPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        mainPage.open();
    }

    public void enterStandardCredentials() {
        mainPage.enterCredentials();
    }

    public void clickOnLogin() {
        mainPage.clickLoginButton();
    }

    public void viewProductPage() {
        mainPage.getLoginStatus();
    }

    // SCENARIO 2
    public void loginAsStandardUser() {
        mainPage.enterCredentials();
        mainPage.clickLoginButton();
    }

    public void clickOnBurgerMenu() {
        productsPage.clickOnMenu();
    }

    public void clickOnAboutTab() {
        productsPage.clickOnAbout();
    }

    public void backToProductsPage() {
        productsPage.backToProductsPage();
    }

    // SCENARIO 3
    public void filterProductsByType(String productType) {
        productsPage.filterProducts(productType);
    }

    public void addProductsToCart(String productNumber) {

    }

    public void viewNumberOfProducts(String productNumber) {

    }
}
