package Saucedemo.steps;

import Saucedemo.pageobject.MainPage;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;

public class SaucedemoUser extends ScenarioActor {
    String actor;

    @Steps(shared = true)
    MainPage mainPage;

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
}
