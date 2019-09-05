package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import com.codecool.util.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout extends BasePage {
    @FindBy(xpath = "//span[@id='navbar-text']")
    WebElement logOutBar;
    @FindBy(id = "logout")
    WebElement logOutLink;
    @FindBy(xpath = "/html//a[@href='/shopping-cart']/span/i[2]")
    WebElement shoppingcart;

    public void doLogout() throws Exception {
        logOutBar.click();
        Wait.waitForVisibility(logOutLink);
        logOutLink.click();
    }
}
