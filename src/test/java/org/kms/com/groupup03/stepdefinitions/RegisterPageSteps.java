package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.RegisterPage;
import org.kms.com.groupup03.utils.DataGenerator;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.Data;

public class RegisterPageSteps extends BasePage {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    @Given("user navigate to Register page")
    public void userNavigateToRegisterPage() {
        registerPage.navigateToRegisterPage();
    }
    @And("user click on Agree Policy checkbox")
    public void userClickOnAgreePolicyCheckbox() {
        registerPage.clickOnAgreePolicyCheckbox();
    }

    @And("user click on Continue button")
    public void userClickOnContinueButton() {
        registerPage.clickOnRegisterButton();
    }

    @Then("verify that registration has been successful")
    public void verifyThatRegistrationHasBeenSuccessful() {
    }

    @Given("user logout account")
    public void userLogoutAccount() {
        registerPage.clickOnLogoutButton();
    }


    @Given("user type in the Firstname with value {} Lastname with value {} Telephone with value {} Fax with value {} Company with value {} First Address with value {} Second Address with value {} City with value {} ZIP code with value {}")
    public void registerWithFullInformation(String firstName, String lastName, String telephone, String fax, String company, String address1, String address2, String city, String zip) {
        CommonPageSteps.loginName = DataGenerator.randomLoginName();
        CommonPageSteps.password = DataGenerator.randomPassword();
        String email = CommonPageSteps.loginName + "@gmail.com";
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterFax(fax);
        registerPage.enterCompany(company);
        registerPage.enterAddress1(address1);
        registerPage.enterAddress2(address2);
        registerPage.enterCity(city);
        registerPage.enterPostCode(zip);
        registerPage.enterLoginName(CommonPageSteps.loginName);
        registerPage.enterPassword(CommonPageSteps.password);
        registerPage.enterPasswordConfirm(CommonPageSteps.password);
    }
}