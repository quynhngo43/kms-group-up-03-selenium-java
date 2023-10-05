package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
    final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//ul[contains(@class,'main_menu')]//a[normalize-space(.)='Login or register']")
    public WebElement eMainMenuItemRegisterLogin;

    @FindBy(xpath = "//input[@name='loginname']")
    public WebElement eLoginNameTextbox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement ePasswordTextbox;

    @FindBy(xpath = "//div[contains(text(), 'Welcome back']")
    public WebElement eLoginSuccessMessage;

    @FindBy(xpath = "//div[@class='alert alert-error alert-danger']")
    public WebElement eLoginErrorMessage;

    public static final String SUCCESS_LOGIN_MESSAGE_XPATH = "//div[contains(text(), '%s')]";

    public void navigateToLoginPage(){
        eMainMenuItemRegisterLogin.click();
    }

    public void enterLoginName(String loginName) {
        CommonPage.setText(eLoginNameTextbox, loginName);
    }

    public void enterPassword(String password) {
        CommonPage.setText(ePasswordTextbox, password);
    }

    public void verifyLoginMessage(String type, String message) {
        if (type.equals("successful")) {
            WebElement element = this.driver.findElement(By.xpath(String.format(SUCCESS_LOGIN_MESSAGE_XPATH, message)));
            CommonPage.verifyMessageByGetText(element, message);
        }
        else if (type.equals("error")) {
            Assert.assertNotNull(eLoginErrorMessage);
        }
    }
}
