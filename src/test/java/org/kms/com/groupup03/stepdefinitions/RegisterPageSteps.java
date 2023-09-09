package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.Given;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.RegisterPage;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageSteps extends BasePage {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    @Given("user navigate to Register page")
    public void userNavigateToRegisterPage() {
        registerPage.navigateToRegisterPage();
    }

}