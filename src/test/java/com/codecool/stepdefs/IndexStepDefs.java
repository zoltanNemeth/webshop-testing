package com.codecool.stepdefs;


import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.Index;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class IndexStepDefs {
    private Index indexPage;

    @Given("I have Products and a Product Category in the application")
    public void iHaveProductsAndAProductCategoryInTheApplication() {
        // Don't have permission to the database to check this step
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
        assertTrue(indexPage.areThereProductsAndProductCategories());
    }

    @When("I I click on a Category's title")
    public void iIClickOnACategorySTitle() {
        indexPage.clickOnCategory("Laptop");
    }

    @Then("ensure it displays the Products only in the selected Category")
    public void ensureItDisplaysTheProductsOnlyInTheSelectedCategory() {
        assertTrue(indexPage.areThereOnlyProductsFromSpecificCategory("laptop"));
        indexPage.clickOnCategory("Categories");
    }

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
        indexPage = new Index();
        indexPage.goTo();
        assertTrue(indexPage.areThereProductsAndSuppliers());
    }

    @When("I I click on a Supplier's name")
    public void iIClickOnASupplierSName() {
        indexPage.clickOnSupplier("Apple");
    }

    @Then("ensure it displays the Products only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier() {
        List<String> expectedSuppliers = List.of("Apple iPhone X", "Mac Pro (Standard)", "Mac Pro (Top-end)");
        assertTrue(indexPage.areThereOnlySpecificProductsWithTitles(expectedSuppliers));
        indexPage.clickOnSupplier("Suppliers");
        WebDriverSingleton.closeWebBrowser();
    }
}
