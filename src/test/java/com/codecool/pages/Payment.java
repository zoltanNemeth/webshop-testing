package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment extends BasePage {
    @FindBy(xpath = "//form[@action='/payment']")
    WebElement paymentForm;

    @FindBy(xpath = "/html/body/div[2]/div/form/div[2]/div/div[2]/div[3]/div/div/span")
    WebElement totalPrice;

    @FindBy(xpath = "//button[contains(text(), 'Confirm payment')]")
    WebElement cardPayment;

    @FindBy(xpath = "//select[@name='CreditCardType']")
    WebElement cardType;

    public WebElement getPaymentForm() {
        return paymentForm;
    }

    public void goTo() {
        driver.get("http://localhost:8888/payment");
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement cardOption() {
        return cardPayment;
    }

    public WebElement cardType() {
        return cardType;
    }
}
