package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    @FindBy(xpath = "//*[@id='login_credentials']")
    WebElementFacade standardUserText;

    @FindBy(xpath="//*[@class='login_password']")
    WebElementFacade allUsersPassword;

    @FindBy(xpath="//*[@id='user-name']")
    WebElementFacade usernameInput;

    @FindBy(xpath="//*[@id='password']")
    WebElementFacade passwordInput;

    @FindBy(xpath="//*[@id='login-button']")
    WebElementFacade loginButton;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElementFacade lblProducts;

    public void enterCredentials() {
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void getLoginStatus() {
        //String isProductsPageUrl = currentURL;
        Assert.assertTrue(lblProducts.isDisplayed());
        String details = "'Products page' displayed after login: " + lblProducts.isDisplayed();
        Serenity.recordReportData().withTitle("Login Status").andContents(details);
    }
}
