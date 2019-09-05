package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutForm extends BasePage{
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@name='email_address']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='phone_number']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@name='billing-country']")
    WebElement countryField;

    @FindBy(xpath = "//input[@name='billing-city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@name='billing-zipcode']")
    WebElement zipField;

    @FindBy(xpath = "//input[@name='billing-address']")
    WebElement addressField;

    @FindBy(xpath = "//button[@name='submit']")
    WebElement submitButton;

    public void fillName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void fillEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void fillCountry(String country) {
        countryField.clear();
        countryField.sendKeys(country);
    }
    public void fillCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }
    public void fillZip(String zip) {
        zipField.clear();
        zipField.sendKeys(zip);
    }
    public void fillAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }
    public void submitCheckout() {
        submitButton.click();
    }

    public WebElement getNameField() {
        return nameField;
    }
}
