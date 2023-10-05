package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPage {
    final WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//span[@class='cart_total']")
    public WebElement eCartItem;

    @FindBy(xpath = "//a[@id='cart_checkout1']")
    public WebElement eCheckoutButton;

    @FindBy(xpath="//i[@class='fa fa-refresh']")
    public WebElement eUpdateButton;

    public final String ERROR_MESSAGE_XPATH = "//strong[text()='%s']";

    public final String PRODUCT_INPUT_XPATH = "//td[@class='align_left']//a[text()='%s']//ancestor::tr//td[5]//div//input";

    public final String PRODUCT_REMOVE_BUTTON_XPATH = "//a[text()='%s']//ancestor::tr//i[contains(@class, 'trash')]";

    public void enterProductQuantity(String productName, String quantity) {
        WebElement element = this.driver.findElement(By.xpath(String.format(PRODUCT_INPUT_XPATH, productName)));
        CommonPage.setText(element, quantity);
        eUpdateButton.click();
    }

    public void removeProductFromCart(String productName) {
        WebElement element = this.driver.findElement(By.xpath(String.format(PRODUCT_REMOVE_BUTTON_XPATH, productName)));
        element.click();
    }

    public void checkoutExistingItems() {
        eCartItem.click();
    }

    public void confirmCheckout() {
        eCheckoutButton.click();
    }

    public void verifyThatCannotCheckoutMessage(String message) {
        WebElement element = this.driver.findElement(By.xpath(String.format(ERROR_MESSAGE_XPATH, message)));
        CommonPage.verifyMessageByGetText(element, message);
    }
}