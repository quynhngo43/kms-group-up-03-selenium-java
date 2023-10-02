package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.HomePage;
import org.kms.com.groupup03.pageobjects.RegisterPage;
import org.openqa.selenium.support.PageFactory;


public class SearchProductsSteps extends BasePage {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @And("search product with category {string} and keywords {string}")
    public void searchProductWithCategoryAndKeywords(String category, String keywords) {
        homePage.searchByCategory(category, keywords);
    }
}
