package Saucedemo.stepsdefinitions;

import Saucedemo.steps.SaucedemoUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenityReports;
import net.thucydides.core.annotations.Steps;

public class UserStepsDefinition {
    @Steps(shared = true)
    SaucedemoUser saucedemoUser;

    // SCENARIO 1
    @Given("^user navigates to https://www.saucedemo.com/$")
    public void userNavigatesToSaucedemo() {
        saucedemoUser.navigatesToSaucedemo();
        Serenity.takeScreenshot();
    }

    @Given("^user enters credentials for standard user$")
    public void userEntersCredentialsStandard() {
        saucedemoUser.enterStandardCredentials();
        Serenity.takeScreenshot();
    }

    @When("^clicks on Login$")
    public void userClicksOnLogin() {
        saucedemoUser.clickOnLogin();
        Serenity.takeScreenshot();
    }

    @Then("^user views Products page$")
    public void userViewsProductPage() {
        saucedemoUser.viewProductPage();
        Serenity.takeScreenshot();
    }

    // SCENARIO 2
    @Given("^user logs in to https://www.saucedemo.com/$")
    public void userLogsIn() {
        saucedemoUser.navigatesToSaucedemo();
        saucedemoUser.loginAsStandardUser();
        Serenity.takeScreenshot();
    }

    @When("^clicks on burger menu in the corner$")
    public void userClicksOnBurgerMenu() {
        saucedemoUser.clickOnBurgerMenu();
        Serenity.takeScreenshot();
    }

    @And("^clicks on About tab$")
    public void userClicksOnAboutTab() {
        saucedemoUser.clickOnAboutTab();
        Serenity.takeScreenshot();
    }

    @And("^goes back to previous page$")
    public void userGoesBackToProductsPage() {
        saucedemoUser.backToProductsPage();
        Serenity.takeScreenshot();
    }

    // SCENARIO 3
    @When("^filters products by (.*)$")
    public void userFiltersByType(String productFilter) {
        saucedemoUser.filterProductsByType(productFilter);
        Serenity.takeScreenshot();
    }

    @And("^adds the (.*) most expensive products to the cart$")
    public void userAddsProductsToCart(String productNumber) {
        saucedemoUser.addExpensiveProductsToCart(productNumber);
        Serenity.takeScreenshot();
    }

    @Then("^the (.*) of added products is reflected on the cart icon$")
    public void userViewsNumberOfProducts(String productNumber) {
        saucedemoUser.viewNumberOfProducts(productNumber);
        Serenity.takeScreenshot();
    }

    // SCENARIO 4
    @And("^user adds (.*) items to the cart$")
    public void userAddsItemsToCart(String productNumber) {
        saucedemoUser.addItemsToCart(productNumber);
        Serenity.takeScreenshot();
    }

    @When("^goes to checkout of items in cart$")
    public void userGoesToCheckout() {
        saucedemoUser.goToCheckout();
        Serenity.takeScreenshot();
    }

    @And("^fills up Personal Information - (.*), (.*), (.*)$")
    public void userFillsUpPersonalInfo(String firstName, String lastName, String postalCode) {
        saucedemoUser.fillUpPersonalInfo(firstName, lastName, postalCode);
        Serenity.takeScreenshot();
    }

    @Then("^the Total Price with tax is correct$")
    public void userViewsCorrectTotalPrice() {
        saucedemoUser.viewCorrectTotalPrice();
        Serenity.takeScreenshot();
    }

    // SCENARIO 5
    @When("^completes checkout$")
    public void userCompletesCheckout() {
        saucedemoUser.completeCheckout();
        Serenity.takeScreenshot();
    }

    @Then("^user views Success Message$")
    public void userViewsCheckoutSuccessPage() {
        saucedemoUser.viewCheckoutSuccessPage();
        Serenity.takeScreenshot();
    }

}