package com.codecool.pages;


import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
import org.openqa.selenium.WebDriver;
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
    @FindBy(xpath = "//span[@id='navbar-text']/b")
    WebElement logOutBar;
    @FindBy(xpath = "//p[@id='modalErrorMessage']//b[.=' Login failed. Wrong username or password! ']")
    WebElement errorMessage;
    private Wait wait = new Wait();


    public void goTo() {
        driver.get("http://localhost:8888/");
    }


    public void getLoginForm() {
        loginLink.click();
    }

    public void fillUserNameField(String userName) throws Exception {
        Wait.waitForVisibility(userNameField);
        userNameField.isDisplayed();
        userNameField.clear();
        userNameField.sendKeys(userName);

    }


    public void fillPasswordField(String password) {
        passwordField.isDisplayed();
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void doLogin() {
        loginButton.isDisplayed();
        loginButton.click();
    }

    public void doLoginInvalidInfo(String username, String password) throws Exception {
        fillUserNameField(username);
        fillPasswordField(password);
        doLogin();

    }

    public String theUserIsLogged() {
        String loggedUser = logOutBar.getText();
        System.out.println(loggedUser);
        return logOutBar.getText();
    }

    public void ErrorMessageWhileInvalidInfoisDisplayed() {
        errorMessage.isDisplayed();
    }

    public void userNotLoggedIn() {
        Wait.waitForVisibility(loginLink);
    }
}
