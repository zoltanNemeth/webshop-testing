package com.codecool.stepdefs;

import com.codecool.pages.Index;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MainPage {
    private Index indexPage;

    @Given("I have Products and a Product Category in the application")
    public void iHaveProductsAndAProductCategoryInTheApplication() {
    }

    @When("I open the root url {string}")
    public void iOpenTheRootUrl(String arg0) {
        indexPage = new Index();
        indexPage.goTo();
    }

    @Then("ensure I can see a list of Products")
    public void ensureICanSeeAListOfProducts() {
    }

    @And("ensure that the following details are displayed: {string}, {string}, {string}, {string}")
    public void ensureThatTheFollowingDetailsAreDisplayed(String arg0, String arg1, String arg2, String arg3) {
    }

    @Given("I have Products and Product Categories listed on the index page")
    public void iHaveProductsAndProductCategoriesListedOnTheIndexPage() {
        
    }

    @When("I I click on a Category's title")
    public void iIClickOnACategorySTitle() {
    }

    @Then("ensure it displays the Products only in the selected Category")
    public void ensureItDisplaysTheProductsOnlyInTheSelectedCategory() {
    }

    @Given("I have Products and Suppliers listed on the index page")
    public void iHaveProductsAndSuppliersListedOnTheIndexPage() {
    }

    @When("I I click on a Supplier's name")
    public void iIClickOnASupplierSName() {
    }

    @Then("ensure it displays the Products only for the selected Supplier")
    public void ensureItDisplaysTheProductsOnlyForTheSelectedSupplier() {
    }
}
