package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCart extends BasePage {
    @FindBy(xpath = "//button[@data-item-id='3']")
    WebElement addToCartBtn;
    @FindBy(xpath = "//span[@class='fa-stack fa-2x has-badge']")
    WebElement shoppingCartBtn;
    @FindBy(xpath = "//h4[text()='Amazon Fire HD 8']")
    WebElement productName;
    //@FindBy(xpath = "//tr[@data-prod-id='3']")
    @FindBy(xpath = "//td[@data-th='Quantity']/input")
    List<WebElement> quantities;

    Integer itemCount;
    Integer productCount;

    public ShoppingCart() {
    }

    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }

    public boolean validateAddToCartBtnIsPresent(String btnText) {
        return addToCartBtn.getText().equals(btnText);
    }

    public void clickOnShoppingCartBtn() {
        shoppingCartBtn.click();
    }

    public boolean shoppingCartIsPresent() {
        return shoppingCartBtn.isDisplayed();
    }

    public boolean newOrderIsAddedToTheCart() {
        itemCount = Integer.valueOf(shoppingCartBtn.getAttribute("data-count"));
        return itemCount > itemCount - 1;
    }

    /*
    public boolean validateProductNumberIncreasedBy(int num) {
        productCount = Integer.valueOf(quantity.getAttribute("value"));
        return productCount < productCount + num;
    }
     */

    public boolean validateProductIsStoredInTheCart(String productName) {
        clickOnShoppingCartBtn();
        return this.productName.getText().equals(productName);
    }

    public boolean validateItemCountEqualsAllQuantity() {
        Integer allQuantity = 0;

        for (WebElement quantity : quantities) {
            allQuantity += Integer.valueOf(quantity.getAttribute("value"));
        }

        return itemCount.equals(allQuantity);
    }

}
