package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeliveryPage {
    final WebDriver driver;
    public DeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@id='checkout_btn']")
    WebElement eCheckoutButton;

    @FindBy(xpath= "//h3[@class='text-success']")
    WebElement eSuccessOrderMessage;

    public final String DELIVERY_CHECKBOX_XPATH = "//b[text()='%s']//ancestor::tr//following-sibling::tr[1]//div[@class='checkbox_place']";

    public void selectDeliveryType(String deliveryType) {
        WebElement element = this.driver.findElement(By.xpath(String.format(DELIVERY_CHECKBOX_XPATH, deliveryType)));
        element.click();
    }

    public void confirmOrder() {eCheckoutButton.click();
    }

    public void verifyThatOrderCompleted(String message) {
        CommonPage.verifyMessageByGetText(eSuccessOrderMessage, message);
    }
}
