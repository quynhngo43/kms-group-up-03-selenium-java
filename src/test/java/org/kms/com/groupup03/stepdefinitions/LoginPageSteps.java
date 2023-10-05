package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.LoginPage;
import org.kms.com.groupup03.utils.DataGenerator;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class LoginPageSteps extends BasePage {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Given("user navigate to Login page")
    public void userNavigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @And("user type in the Loginname and Password to login with {} data")
    public void userTypeInTheLoginnameAndPasswordToLoginWithData(String isValidData) {
        loginPage.enterLoginName(CommonPageSteps.loginName);
        if (isValidData.equals("valid")) {
            loginPage.enterPassword(CommonPageSteps.password);
        }
        else if (isValidData.equals("invalid")) {
            loginPage.enterPassword(DataGenerator.randomPassword());
        }
    }

    @Then("verify that user receive {} message {}")
    public void verifyThatUserReceiveMessage(String type, String expectedMessage) {
        loginPage.verifyLoginMessage(type, expectedMessage);
    }
}