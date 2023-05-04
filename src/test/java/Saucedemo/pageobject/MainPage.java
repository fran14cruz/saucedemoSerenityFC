package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(xpath="//*[@id='login_credentials']/text()[1]")
    WebElementFacade standardUserText;

    @FindBy(xpath="//*[@class='login_password']/text()")
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
        usernameInput.sendKeys(standardUserText.getText());
        passwordInput.sendKeys(allUsersPassword.getText());
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean lblProductsIsDisplayed() {
        return  lblProducts.isDisplayed();
    }

    public void getLoginStatus() {
        //String isProductsPageUrl = currentURL;
        String details = "'Products page' displayed after login: " + lblProductsIsDisplayed();
        Serenity.recordReportData().withTitle("Login Status").andContents(details);
    }


}
