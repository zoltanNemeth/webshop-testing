package com.codecool.wait;

import com.codecool.driver.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private static WebDriverWait webDriverWait;
    private int timeOutSeconds=3;


    public Wait() {
        webDriverWait = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(),timeOutSeconds);
    }


    public static void waitForVisibility(WebElement element) throws Error {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}