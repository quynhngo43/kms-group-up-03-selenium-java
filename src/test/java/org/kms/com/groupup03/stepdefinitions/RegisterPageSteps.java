package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.RegisterPage;
import org.kms.com.groupup03.utils.DataGenerator;
import org.openqa.selenium.support.PageFactory;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

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

    @And("user type in the Firstname as {} Lastname as {} Telephone as {} Fax as {} Company as {} First Address as {} Second Address as {} City as {} ZIP code as {}")
    public void registerWithFullInformationn(String firstName, String lastName, String telephone, String fax, String company, String address1, String address2, String city, String zip, List<Map<String,String>> information) {
        CommonPageSteps.loginName = DataGenerator.randomLoginName();
        CommonPageSteps.password = DataGenerator.randomPassword();
        String email = CommonPageSteps.loginName + "@gmail.com";
        System.out.println("print sthh");
        System.out.println(information.get(0).get("firstname"));
        registerPage.enterFirstName(information.get(0).get("firstname"));
        registerPage.enterLastName(information.get(0).get("lastname"));
        registerPage.enterEmail(email);
        registerPage.enterTelephone(information.get(0).get("telephone"));
        registerPage.enterFax(information.get(0).get("fax"));
        registerPage.enterCompany(information.get(0).get("company"));
        registerPage.enterAddress1(information.get(0).get("firstAddress"));
        registerPage.enterAddress2(information.get(0).get("secondAddress"));
        registerPage.enterCity(information.get(0).get("city"));
        registerPage.enterPostCode(information.get(0).get("zip"));
        registerPage.enterLoginName(CommonPageSteps.loginName);
        registerPage.enterPassword(CommonPageSteps.password);
        registerPage.enterPasswordConfirm(CommonPageSteps.password);
    }
}