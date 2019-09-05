package com.codecool.stepdefs;

import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.Index;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;


public class MainPage {
    private Index indexPage;

    @Given("I have Products and a Product Category in the application")
    public void iHaveProductsAndAProductCategoryInTheApplication() {
        // Don't have permission to the database to ensure this step
    }

    @When("I open the root url")
    public void iOpenTheRootUrl() {
        indexPage = new Index();
        indexPage.goTo();
        assertTrue(indexPage.isAt());
    }

    @Then("ensure I can see a list of Products")
    public void ensureICanSeeAListOfProducts() {
        assertTrue(indexPage.isThereAListOfProducts());
    }

    @And("ensure that the following details are displayed: productTitle, description, image, price")
    public void ensureThatTheFollowingDetailsAreDisplayedProductTitleDescriptionImagePrice() {
        assertTrue(indexPage.areDetailsDisplayed());
    }

    @Given("I have Products and Product Categories listed on the index page")
    public void iHaveProductsAndProductCategoriesListedOnTheIndexPage() {
        indexPage = new Index();
        assertTrue(indexPage.areThereProductCategories());
    }

    @When("I I click on a Category's title")
    public void iIClickOnACategorySTitle() {
        indexPage.searchForCategory("Laptop");
    }

    @Then("ensure it displays the Products only in the selected Category")
    public void ensureItDisplaysTheProductsOnlyInTheSelectedCategory() {
        assertTrue(indexPage.areThereOnlyLaptops());
    }

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
    }

    @When("I I click on a Supplier's name")
    public void iIClickOnASupplierSName() {
    }

    @Then("ensure it displays the Products only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier() {
//        WebDriverSingleton.closeWebBrowser();
    }
}
