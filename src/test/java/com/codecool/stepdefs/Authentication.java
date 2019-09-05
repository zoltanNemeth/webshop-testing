package com.codecool.stepdefs;

import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.Index;
import com.codecool.pages.Login;
import com.codecool.pages.Logout;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Authentication {
    private Login login = new Login();
    private Logout logout = new Logout();
    private Index index = new Index();


    @When("the user chooses the Login menu")
    public void theUserChoosesTheLoginMenu() {
        login.getLoginForm();

    }


    @When("the user submits the form with valid information")
    public void theUserSubmitsTheFormWithValidInformation() {
        login.doLogin();

    }

    @Then("I close browser")
    public void iCloseBrowser() {
        WebDriverSingleton.closeWebBrowser();
    }


    @Then("ensure to provide a login form with the following fields {string} and {string}")
    public void ensureToProvideALoginFormWithTheFollowingFieldsAnd(String userName, String password) throws Exception {
        login.fillUserNameField(userName);
        login.fillPasswordField(password);

    }


    @And("ensure to provide a Logout option and the username is shown {string}.")
    public void ensureToProvideALogoutOptionAndTheUsernameIsShown(String username) {
        String loggedUser = login.theUserIsLogged();
        Assert.assertEquals(username, loggedUser);
    }

    @When("the user submits the form with invalid {string} and {string} information")
    public void theUserSubmitsTheFormWithInvalidAndInformation(String user, String password) throws Exception {
        login.doLoginInvalidInfo(user, password);
    }


    @Then("provide an error message.")
    public void provideAnErrorMessage() {
        login.ErrorMessageWhileInvalidInfoisDisplayed();

    }

    @Then("I should logout")
    public void iShouldLogout() throws Exception {
        logout.doLogout();
    }


    @Given("user on the site")
    public void userOnTheSite() {
        index.goTo();
    }
}