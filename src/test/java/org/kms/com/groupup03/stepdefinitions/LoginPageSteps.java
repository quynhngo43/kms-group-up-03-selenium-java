package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.LoginPage;
import org.kms.com.groupup03.utils.DataGenerator;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSteps extends BasePage {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Given("user navigate to Login page")
    public void userNavigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @Given("user click Login button to login")
    public void userClickLoginButtonToLogin() {
        loginPage.clickLogin();
    }

    @Given("user type in the Loginname and Password to login")
    public void userTypeInThePasswordWithValueToLogin() {
        loginPage.enterLoginName(CommonPageSteps.loginName);
        loginPage.enterPassword(CommonPageSteps.password);
    }

    @And("user login with wrong Password")
    public void userLoginWithWrongPassword() {
        String newPassword = DataGenerator.randomPassword();
        loginPage.enterLoginName(CommonPageSteps.loginName);
        loginPage.enterPassword(newPassword);
    }

    @Then("verify that user gets error message with value {string}")
    public void verifyThatUserGetsErrorMessageWithValue(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }
}