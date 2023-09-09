package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.CommonPage;
import org.openqa.selenium.support.PageFactory;

public class CommonPageSteps extends BasePage {
    CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);

    @Then("page title is {string}")
    public void verifyPageTitle(String expectedTitle) {
        commonPage.verifyPageTitle(expectedTitle);
    }
}