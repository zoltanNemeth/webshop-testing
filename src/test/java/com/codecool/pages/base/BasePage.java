package com.codecool.pages.base;

import com.codecool.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    protected final int timeOutInSeconds = 3;

    protected WebDriver driver;

    public BasePage() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutInSeconds), this);
        driver.get("http://localhost:8888/");

    }
}
