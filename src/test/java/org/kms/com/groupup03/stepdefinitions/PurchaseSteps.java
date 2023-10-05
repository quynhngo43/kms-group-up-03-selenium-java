package org.kms.com.groupup03.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.kms.com.groupup03.pageobjects.BasePage;
import org.kms.com.groupup03.pageobjects.CheckoutPage;
import org.kms.com.groupup03.pageobjects.DeliveryPage;
import org.kms.com.groupup03.pageobjects.HomePage;
import org.openqa.selenium.support.PageFactory;

public class PurchaseSteps extends BasePage {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    DeliveryPage deliveryPage = PageFactory.initElements(driver, DeliveryPage.class);

    @And("checkout with the shopping cart")
    public void checkoutWithTheShoppingCart() {
        checkoutPage.checkoutExistingItems();
    }

    @And("confirm checkout")
    public void confirmCheckout() {
        checkoutPage.confirmCheckout();
    }

    @And("add product {string} to card")
    public void addProductToCard(String productName) {
        homePage.addProductToCart(productName);
    }

    @And("edit the number of product {string} to {}")
    public void editTheNumberOfProductWithNumberOfProduct(String productName, String quantity) {
        checkoutPage.enterProductQuantity(productName,quantity);
    }

    @And("remove the product {string} from cart")
    public void removeTheProductFromCart(String productName) {
        checkoutPage.removeProductFromCart(productName);
    }

    @Then("verify that user cannot check out with the message {string}")
    public void verifyThatUserCannotCheckOutWithTheMessage(String errorMessage) {
        checkoutPage.verifyThatCannotCheckoutMessage(errorMessage);
    }

    @And("select Delivery type {string}")
    public void selectDeliveryType(String deliveryType) {
        deliveryPage.selectDeliveryType(deliveryType);
    }

    @And("complete order process")
    public void completeOrderProcess() {
        deliveryPage.confirmOrder();
    }

    @Then("verify that order completed with message {string}")
    public void verifyThatOrderCompleted(String message) {
        deliveryPage.verifyThatOrderCompleted(message);
    }
}
