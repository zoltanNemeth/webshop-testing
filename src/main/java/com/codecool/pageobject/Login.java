package com.codecool.pageobject;


import com.codecool.pageobject.basepage.BasePage;
import com.codecool.wait.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
    private Wait wait = new Wait();

    @FindBy(xpath = "//li[@id='login']/a[@href='#']")
    WebElement loginLink;
    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(xpath = "/html//button[@id='submit-button']")
    WebElement loginButton;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    public Login() {
    }

    public void getLoginForm() {
        loginLink.click();
    }

    public void addUserName(String userName) {
        Wait.waitForVisibility(userNameField);
        userNameField.isDisplayed();
        userNameField.clear();
        userNameField.sendKeys(userName);

    }


    public void addPassword(String password) {
        passwordField.isDisplayed();
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void doLogin() {
        loginButton.click();
    }

}