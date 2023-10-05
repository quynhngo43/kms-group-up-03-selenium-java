package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonPage {

    public static final String BUTTON_XPATH = "//button[@title='%s']";

    final WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPageTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickButtonByTitle(String buttonTitle) {
        WebElement element = this.driver.findElement(By.xpath(String.format(BUTTON_XPATH, buttonTitle)));
        element.click();
    }

    public static void verifyMessageByGetText(WebElement element, String expectedMessage) {
        Assert.assertEquals(element.getText(), expectedMessage);
    }
}
