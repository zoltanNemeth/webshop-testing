package com.codecool.pages;


import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
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


    public void goTo() {
        driver.get("http://localhost:8888/");
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

    public void userNotLoggedIn() {
        Wait.waitForVisibility(loginLink);
    }
}