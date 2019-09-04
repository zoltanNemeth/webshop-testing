package com.codecool.stepdefs;

import com.codecool.pages.Login;
import com.codecool.pages.ShoppingCart;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ShoppingCartStepDefs {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Login login = new Login();

    @Given("^I am logged in$")
    public void iAmLoggedIn() {
        login.getLoginForm();
        login.addUserName("MyName");
        login.addPassword("MyName19!");
        login.doLogin();
    }

    @Given("^I have a Product list$")
    public void productListIsPresent() {

    }

    @And("^the Products have an 'Add to cart' button$")
    public void addToCartButtonIsPresent() {
        Assert.assertTrue(shoppingCart.validateAddToCartBtnIsPresent("Add to cart"));
    }

    @When("^I click on the 'Add to cart' button$")
    public void clickAddToCartButton() {
        shoppingCart.clickOnAddToCartBtn();
    }

    @Then("^ensure it creates a new Order for storing cart data of the User$")
    public void ensureNewOrderIsAdded() {
        Assert.assertTrue(shoppingCart.newOrderIsAddedToTheCart());
    }

    @And("^ensure it creates a new LineItem with the quantity and price of the Product$")
    public void ensureItCreatesANewLineItemWithTheQuantityDefaultAndPriceThePriceOfTheProduct() {
        Assert.assertTrue(shoppingCart.validateProductIsStoredInTheCart("Amazon Fire HD 8"));
        //TODO: price of the product
    }

    @And("^ensure it stores this data in the session$")
    public void ensureItStoresThisDataInTheSession() {
    }

    @And("^ensure it displays the number of cart items in the Page header.$")
    public void ensureItDisplaysTheNumberOfCartItemsInThePageHeader() {
        //Assert.assertTrue(shoppingCart.validateItemCountEqualsAllQuantity());
    }

    @And("^I have a Shopping Cart with items in it$")
    public void shoppingCartIsDisplayedWithItemsInIt() {
        shoppingCart.shoppingCartIsPresent();
        shoppingCart.newOrderIsAddedToTheCart();
    }

    @When("^I click on the 'Shopping cart' menu item in the Page header$")
    public void clickOnTheShoppingCartButton() {
        shoppingCart.clickOnShoppingCartBtn();
    }

    @Then("^ensure it displays the items with the following data:$")
    public void ensureItDisplaysTheLineItemsWithTheFollowingData() {

    }

    @And("^ensure it displays the total price of all the items in the cart$")
    public void ensureItDisplaysTheTotalPriceOfAllItemsInTheCart() {
    }

    /*
    @And("^I have a Shopping Cart review page$")
    public void iHaveAShoppingCartReviewPage() {
    }

    @And("^the LineItems are displayed in a form$")
    public void lineItemsAreDisplayedInAForm() {
    }

    @And("^the quantities are displayed in input fields$")
    public void quantitiesAreDisplayedInInputFields() {
    }

    @When("^I change the quantity of an item$")
    public void changeTheQuantityOfAnItem() {
    }

    @Then("^ensure it stores the new quantity of the LineItem$")
    public void ensureItStoresTheNewQuantityOfTheLineItem() {
    }

    @When("^I change the quantity to (\\d+)$")
    public void changeTheQuantityTo(int arg0) {
    }

    @Then("^ensure it removes the LineItem from the cart$")
    public void ensureItRemovesTheLineItemFromTheCart() {
    }
     */
}
