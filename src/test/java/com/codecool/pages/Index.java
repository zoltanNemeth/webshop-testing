package com.codecool.pages;

import com.codecool.pages.base.BasePage;

public class Index extends BasePage {
    public void goTo() {
        driver.navigate().to("http://localhost:8888/");
    }
}
