package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//ul[contains(@class,'main_menu')]//a[normalize-space(.)='Login or register']")
    public WebElement eMainMenuItemRegister;

    @FindBy(xpath = "//button[@title='Continue']")
    public WebElement eContinueButton;

    @FindBy(xpath = "//input[@id='AccountFrm_firstname']")
    public WebElement eFirstNameTextbox;

    @FindBy(xpath = "//input[@id='AccountFrm_lastname']")
    public WebElement eLastNameTextbox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public WebElement eEmail;

    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public WebElement eTelephone;

    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public WebElement eFax;

    @FindBy(xpath = "//input[@id='AccountFrm_loginname']")
    public WebElement eLoginName;

    @FindBy(xpath = "//input[@id='AccountFrm_password']")
    public WebElement ePassword;

    @FindBy(xpath = "//input[@id='AccountFrm_confirm']")
    public WebElement ePasswordConfirm;

    @FindBy(xpath = "//input[@id='AccountFrm_address_1']")
    public WebElement eAddress1;

    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public WebElement eAddress2;

    @FindBy(xpath = "//input[@id='AccountFrm_city']")
    public WebElement eCity;

    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public WebElement ePostcode;

    @FindBy(xpath = "//input[@id='AccountFrm_company']")
    public WebElement eCompany;

    @FindBy(xpath = "//input[@id='AccountFrm_agree']")
    public WebElement eAgreePolicyCheckbox;

    @FindBy(xpath="//div[@class='menu_text']")
    public WebElement eMenu;

    @FindBy(xpath="//a[@data-original-title='Logoff']")
    public WebElement eLogoutButton;

    public void navigateToRegisterPage(){
        eMainMenuItemRegister.click();
        eContinueButton.click();
    }

    public void enterFirstName(String firstName) {
        CommonPage.setText(eFirstNameTextbox, firstName);
    }
    public void enterLastName(String lastName) {
        CommonPage.setText(eLastNameTextbox, lastName);
    }
    public void enterEmail(String email) {
        CommonPage.setText(eEmail, email);
    }
    public void enterTelephone(String telephone) { CommonPage.setText(eTelephone, telephone);}
    public void enterFax(String fax) { CommonPage.setText(eFax, fax);}
    public void enterLoginName(String loginName) {
        CommonPage.setText(eLoginName, loginName);
    }
    public void enterPassword(String password) {
        CommonPage.setText(ePassword, password);
    }
    public void enterPasswordConfirm(String passwordConfirm) {
        CommonPage.setText(ePasswordConfirm, passwordConfirm);
    }
    public void enterAddress1(String address1) { CommonPage.setText(eAddress1, address1); }
    public void enterAddress2(String address2) { CommonPage.setText(eAddress2, address2);}
    public void enterCity(String city) {
        CommonPage.setText(eCity, city);
    }
    public void enterPostCode(String postcode) {
        CommonPage.setText(ePostcode, postcode);
    }
    public void enterCompany(String company) { CommonPage.setText(eCompany, company);}
    public void clickOnAgreePolicyCheckbox(){
        eAgreePolicyCheckbox.click();
    }

    public void clickOnLogoutButton() {
        eMenu.click();
        eLogoutButton.click();
    }

}