package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

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
    @FindBy(xpath = "/html//p[@id='username-error']")
    WebElement userNameErrorLabel;

    public void navigateTosignUpForm() {
        signUpLink.click();
    }


    public void inputFormisShown() {
        try {
            inputForm.isDisplayed();

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Input form is not displayed!");
        }

    }


    public void fillInputFieldWithData(String user, String email, String password) throws Exception {
        Wait.waitForVisibility(userNameField);
        userNameField.sendKeys(user);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
    }

    public void completeRegistration() {
        registerButton.click();
    }

    public String getLoggedUser() throws Exception {
        Wait.waitForVisibility(userNameBar);
        return userNameBar.getText();
    }

    public boolean errormessageisShown() {

        return userNameErrorLabel.isDisplayed();
    }

}
