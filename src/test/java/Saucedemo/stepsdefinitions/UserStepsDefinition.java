package Saucedemo.stepsdefinitions;

import Saucedemo.steps.SaucedemoUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class UserStepsDefinition {
    @Steps(shared = true)
    SaucedemoUser saucedemoUser;

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
    }

    @Then("^user views Products page$")
    public void userViewsProductPage() {
        saucedemoUser.viewProductPage();
        Serenity.takeScreenshot();
    }
}