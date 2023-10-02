package org.kms.com.groupup03.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@id='filter_keyword']")
    public WebElement eSearchInput;

    @FindBy(xpath = "//a[@id='category_58']")
    public WebElement eMenCategory;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    public WebElement eSearchIcon;

    @FindBy(xpath = "//a[@title='MAN Eau de Toilette Spray']//ancestor::div[@id='maincontainer']//div[4]//div[2]//div[3]//a[1]//i[1]")
    public WebElement eProductMANEauDeToiletteSprayToCartIcon;

    @FindBy(xpath= "//a[@title='Euphoria Men Intense Eau De Toilette Spray']//ancestor::div[@class='thumbnails grid row list-inline']//div[3]//div[2]//div[3]//a[1]//i[1]")
    public WebElement eProductEuphoriaMenIntenseToCartIcon;

    public final String PRODUCT_TO_CARD_XPATH = "//a[@title='%s']//ancestor::div[@class='col-md-3 col-sm-6 col-xs-12']//div[2]//div[3]//a[1]//i[1]";

    public void addProductToCart(String productName) {
        WebElement element = this.driver.findElement(By.xpath(String.format(PRODUCT_TO_CARD_XPATH, productName)));
        element.click();

    }

    public void searchByCategory(String category, String keyword) {
        eSearchInput.click();
        if (category == "Men") {
            eMenCategory.click();
        }
        CommonPage.setText(eSearchInput, keyword);
        eSearchIcon.click();
    }
}
