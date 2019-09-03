Feature: Login

  Scenario Outline: Login user
    When the user chooses the Login menu
    Then ensure to provide a login form with the following fields "<user>" and "<password>"
    When the user submits the form with valid information
    And ensure to provide a Logout option.
    When the user submits the form with invalid information
    Then provide an error message.
    Then reset the session and redirect back to the login form

    Examples:
      | user   | password         |
      | ferike | x^b8C@fWWMb0KzUg |


  Scenario: Close browser
    Then I should log out
    Then I close browser