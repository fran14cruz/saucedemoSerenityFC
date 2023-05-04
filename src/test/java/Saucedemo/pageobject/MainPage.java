package Saucedemo.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageObject {
    //static WebDriver driver = new ChromeDriver();

    //@FindBy(xpath="//*[@id='login_credentials']/text()[1]")
    @FindBy(xpath = "//*[text()='standard_user']/text()[1]")
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
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOf(standardUserText));
//            wait.until(ExpectedConditions.visibilityOf(allUsersPassword));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");
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
