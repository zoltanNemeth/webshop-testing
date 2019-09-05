package com.codecool.pages;

import com.codecool.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Index extends BasePage {

    private final String url = "http://localhost:8888/";

    @FindAll({
        @FindBy(xpath = "//div[@id='products']//div[@class='card']")
    })
    private List<WebElement> productCards;

    @FindAll({
            @FindBy(xpath = "//div[@id='products']//div[@class='card']//p[@class='card-text']")
    })
    private List<WebElement> productDescriptions;

//    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div/img")
//    private WebElement firstProductImage;
//
//    @FindBy(xpath = "//div[@id='products']//div[@class='card'][0]//h4/text()")
//    private WebElement firstProductTitle;
//
//    @FindBy(xpath = "//div[@id='products']//div[@class='card'][0]//p[@class='card-text']/text()")
//    private WebElement firstProductDescription;
//
//    @FindBy(xpath = "//div[@id='products']//div[@class='card'][0]//p[@class='lead']/text()")
//    private WebElement firstProductPrice;

    @FindAll({
            @FindBy(xpath = "//select[@name='categories']//option")
    })
    private List<WebElement> categories;

    @FindBy(xpath = "//select[@name='categories']")
    private WebElement categorySelect;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    public void goTo() {
        driver.navigate().to(this.url);
    }

    public boolean isThereAListOfProducts() {
        return productCards.size() > 1;
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(this.url);
    }

    public boolean areDetailsDisplayed() {
        return true;
    }

    public boolean areThereProductCategories() {
        return categories.size() > 1;
    }

    public void searchForCategory(String category) {
        Select select = new Select(categorySelect);
        select.selectByVisibleText(category);
        searchButton.click();
    }

    public boolean areThereOnlyLaptops() {
        for (WebElement description: productDescriptions) {
            if (!description.getText().contains("laptop")) {
                return false;
            }
        }
        return true;
    }
}
