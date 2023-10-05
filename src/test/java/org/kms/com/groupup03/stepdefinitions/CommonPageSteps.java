package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.CommonPage;
import org.openqa.selenium.support.PageFactory;

public class CommonPageSteps extends BasePage {

    public static String loginName;

    public static String password;
    CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);

    @Then("page title is {string}")
    public void verifyPageTitle(String expectedTitle) {
        commonPage.verifyPageTitle(expectedTitle);
    }

    @And("user click on {string} button")
    public void clickOnButtonByTitle(String buttonTitle) {
        commonPage.clickButtonByTitle(buttonTitle);
    }
}