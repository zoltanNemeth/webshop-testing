package com.codecool.pageobject;

import com.codecool.pageobject.basepage.BasePage;

public class Index extends BasePage {
    public void goTo() {
        driver.navigate().to("http://localhost:8888/");
    }
}
