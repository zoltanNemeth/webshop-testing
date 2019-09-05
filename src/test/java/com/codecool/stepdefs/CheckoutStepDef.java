package com.codecool.stepdefs;

import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.CheckoutForm;
import com.codecool.pages.Login;
import com.codecool.pages.Payment;
import com.codecool.pages.ShoppingCart;
import com.codecool.driver.Wait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;

public class CheckoutStepDef {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Login login = new Login();
    private CheckoutForm checkoutForm = new CheckoutForm();
    private Payment payment = new Payment();

    @And("I have items in the shopping cart")
    public void verifyItemsInShoppingCart() {
        Assertions.assertTrue(shoppingCart.haveItems());
    }

    @Given("I have a Shopping Cart review page")
    public void verifyShoppingCartReviewPage() {
        shoppingCart.goToCart();
        Assertions.assertEquals("Shopping Cart", shoppingCart.getCartTitle());
    }

    @When("I click on the Checkout button")
    public void clickOnCheckOut() {
        shoppingCart.goToCheckOut();
    }

    @Then("I fill the {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void fillTheForm(String name, String email, String phoneNr, String country, String city, String zip, String billingAddress) {
        Wait.waitForVisibility(checkoutForm.getNameField());
        checkoutForm.fillName(name);
        checkoutForm.fillEmail(email);
        checkoutForm.fillPhone(phoneNr);
        checkoutForm.fillCountry(country);
        checkoutForm.fillCity(city);
        checkoutForm.fillZip(zip);
        checkoutForm.fillAddress(billingAddress);
    }

    @And("I click on the submit button")
    public void submitUserData() {
        checkoutForm.submitCheckout();
    }

    @And("it stores the validated data to the Order")
    public void checkDataBaseForData() {
        //TODO
    }

    @Then("it redirects to the Payment page")
    public void verifyPaymentPageAppears() {
        Assertions.assertNotNull(Wait.verifyElement(payment.getPaymentForm()));
    }

    @Given("I checked-out the items from the Shopping cart")
    public void goToPayment() {
        payment.goTo();
    }

    @Then("I can see the total price what I have to pay")
    public void verifyTotalPrice() {
        Assertions.assertNotNull(Wait.verifyElement(payment.getTotalPrice()));
    }

    @And("I can choose from the following payment methods credit card and paypal")
    public void verifyPaymentMethods() {
        Assertions.assertNotNull(Wait.verifyElement(payment.cardOption()));
    }

    @Then("based on the selected payment method I can enter enter the credentials for the payment provider:")
    public void verifyFields() {
        Assertions.assertNotNull(Wait.verifyElement(payment.cardType()));
        WebDriverSingleton.closeWebBrowser();
    }

    @Given("a user is logged in")
    public void logInUser() {
        login.goTo();
        try {
            login.userNotLoggedIn();
            login.getLoginForm();
            login.addUserName("pepperoni");
            login.addPassword("@Petrapak13");
            login.doLogin();
        } catch (TimeoutException exception) {
            System.out.println("User logged in, pass it.");
        }
    }
}