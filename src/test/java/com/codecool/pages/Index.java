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

    @FindAll({
            @FindBy(xpath = "//select[@name='categories']//option")
    })
    private List<WebElement> categories;

    @FindAll({
            @FindBy(xpath = "//select[@name='suppliers']//option")
    })
    private List<WebElement> suppliers;

    @FindBy(xpath = "//select[@name='categories']")
    private WebElement categorySelect;

    @FindBy(xpath = "//select[@name='suppliers']")
    private WebElement supplierSelect;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    @FindAll({
            @FindBy(xpath = "//div[@id='products']//h4[@class='card-title']")
    })
    private List<WebElement> productTitles;

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

    public boolean areThereProductsAndProductCategories() {
        return (categories.size() > 1) && (productCards.size() > 1);
    }

    public void clickOnCategory(String category) {
        Select select = new Select(categorySelect);
        select.selectByVisibleText(category);
        searchButton.click();
    }

    public boolean areThereOnlyProductsFromSpecificCategory(String category) {
        for (WebElement description: productDescriptions) {
            if (!description.getText().contains(category)) {
                return false;
            }
        }
        return true;
    }

    public boolean areThereProductsAndSuppliers() {
        return (suppliers.size() > 1) && (productCards.size() > 1);
    }

    public void clickOnSupplier(String supplier) {
        Select select = new Select(supplierSelect);
        select.selectByVisibleText(supplier);
        searchButton.click();
    }

    public boolean areThereOnlySpecificProductsWithTitles(List expectedSuppliers) {
        for (WebElement productTitle: productTitles) {
            if (!expectedSuppliers.toString().contains(productTitle.getText())) {
                return false;
            }
        }
        return true;
    }
}
