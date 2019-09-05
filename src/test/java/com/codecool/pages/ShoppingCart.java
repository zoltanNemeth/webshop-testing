package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage {
    @FindBy(xpath = "//a[@href='/shopping-cart']/span")
    WebElement cartIcon;

    @FindBy(xpath = "//h1")
    WebElement cartTitle;

    @FindBy(partialLinkText = "Checkout")
    WebElement checkOutButton;

    public boolean haveItems() {
        return Integer.valueOf(cartIcon.getAttribute("data-count")) > 0;
    }

    public String getCartTitle() { return cartTitle.getText(); }

    public void goToCart() {
        cartIcon.click();
    }

    public void goToCheckOut() {
        checkOutButton.click();
    }
}
