package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends BasePage {
    @FindBy(xpath = "//li[@id='register']//i")
    WebElement signUpLink;
    @FindBy(xpath = "//form[@id='inputForm']")
    WebElement inputForm;
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='password_confirm']")
    WebElement passwordConfirmationField;
    @FindBy(xpath = "//button[@id='submit-button']")
    WebElement registerButton;
    @FindBy(xpath = "//span[@id='navbar-text']/b")
    WebElement userNameBar;

    public void navigateTosignUpForm() {
        signUpLink.click();
    }


    public void inputFormisShown() {
        inputForm.isDisplayed();

    }


    public void fillInputFieldWithData(String user, String email, String password) {
        userNameField.sendKeys(user);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
    }

    public void completeRegistration() {
        registerButton.click();
    }

    public String getLoggedUser() {
        return userNameBar.getText();
    }


}
