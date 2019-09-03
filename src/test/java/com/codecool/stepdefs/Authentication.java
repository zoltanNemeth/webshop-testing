package com.codecool.stepdefs;

import com.codecool.driver.WebDriverSingleton;
import com.codecool.pages.Login;
import cucumber.api.java.en.And;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Authentication {
    private Login login = new Login();


    @When("the user chooses the Login menu")
    public void theUserChoosesTheLoginMenu() {
        login.getLoginForm();

    }


    @When("the user submits the form with valid information")
    public void theUserSubmitsTheFormWithValidInformation() {
        login.doLogin();

    }

    @And("ensure to provide a Logout option.")
    public void ensureToProvideALogoutOption() {
    }


    @When("the user submits the form with invalid information")
    public void theUserSubmitsTheFormWithInvalidInformation() {

    }

    @Then("provide an error message.")
    public void provideAnErrorMessage() {

    }

    @When("the user chooses the {string}Logout{string} option")
    public void theUserChoosesTheLogoutOption(String arg0, String arg1) {

    }

    @Then("reset the session and redirect back to the login form")
    public void resetTheSessionAndRedirectBackToTheLoginForm() {

    }

    @Then("I should log out")
    public void iShouldLogOut() {
    }

    @Then("I close browser")
    public void iCloseBrowser() {
        WebDriverSingleton.closeWebBrowser();
    }


    @Then("ensure to provide a login form with the following fields {string} and {string}")
    public void ensureToProvideALoginFormWithTheFollowingFieldsAnd(String arg0, String arg1) {
        login.addUserName(arg0);
        login.addPassword(arg1);
    }



}