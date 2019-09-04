Feature: Registration

  Scenario: Registration  with valid information
    Given that there is a Sign up option on the website
    And it has a form with all the required fields: name, email, password
    Then Then ensure the system saves it's data as a new User


  Scenario: Registration  with invalid information
    Given that there is a Sign up option on the website
    And it has a form with all the required fields: name, email,
    When the User submits the form with invalid information
    Then ensure the program shows the same form with the incorrect data, and some description about the errors."


  Scenario: Close browser
    Then I close browser