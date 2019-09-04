package com.codecool.stepdefs;

import com.codecool.pages.Login;
import com.codecool.pages.Registration;
import com.codecool.util.wait.RandomId;
import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegistrationSteps {
    private String expectedUserName;
    private Registration registration = new Registration();
    private Faker faker = new Faker();
    private Login login = new Login();


    @Given("that there is a Sign up option on the website")
    public void thatThereIsASignUpOptionOnTheWebsite() {
        registration.navigateTosignUpForm();
    }

    @And("it has a form with all the required fields: name, email, password")
    public void itHasAFormWithAllTheRequiredFieldsNameEmailPassword() {
        registration.inputFormisShown();
    }


    @And("it has a form with all the required fields: name, email,")
    public void itHasAFormWithAllTheRequiredFieldsNameEmail() {
        String user = faker.name();
        expectedUserName = user;
        String email = faker.firstName() + "@gmail.com";
        String capitalUser = faker.firstName().toUpperCase();
        String password = RandomId.generateUniqueId() + capitalUser + "@";
        registration.fillInputFieldWithData(user, email, password);
        registration.completeRegistration();


    }

    @When("Then ensure the system saves it's data as a new User")
    public void thenEnsureTheSystemSavesItSDataAsANewUser() throws Exception {
        String user = registration.getLoggedUser();
        Assert.assertEquals(expectedUserName, user);
    }

    @Then("ensure the program shows the same form with the incorrect data, and some description about the errors.\"")
    public void ensureTheProgramShowsTheSameFormWithTheIncorrectDataAndSomeDescriptionAboutTheErrors() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }


    @When("the User submits the form with invalid information")
    public void theUserSubmitsTheFormWithInvalidInformation() {
    }


}