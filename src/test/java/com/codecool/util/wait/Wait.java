package com.codecool.util.wait;

import com.codecool.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Wait {
    private static WebDriverWait webDriverWait;
    private int timeOutSeconds = 5;


    public Wait() {
        webDriverWait = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), timeOutSeconds);
    }


    public static void waitForVisibility(WebElement element) throws Exception {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
