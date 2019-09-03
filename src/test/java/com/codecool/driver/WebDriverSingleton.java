package com.codecool.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static final Path PATH_TO_CONFIG = Paths.get(
            System.getProperty("user.dir"), "/src/test/resources/properties.properties");

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", getProperties().getProperty("webdriverPath"));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);

        }
        return driver;
    }

    public static void closeWebBrowser() {
        if (null != driver) {
            driver.quit();
        }
        driver = null;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(Files.newBufferedReader(PATH_TO_CONFIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}