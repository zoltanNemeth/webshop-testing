Feature: Login / Logout

  Scenario Outline: Login user

    When the user chooses the Login menu
    Then ensure to provide a login form with the following fields "<user>" and "<password>"
    When the user submits the form with valid information
    And ensure to provide a Logout option and the username is shown "<user>".

    Examples:
      | user     | password         |
      | andriska | 65ZyxEqGeQ4vv6*% |

  Scenario: Close browser
    Then I should logout
    Then I close browser

  Scenario Outline:Login with invalid information
    When the user chooses the Login menu
    When the user submits the form with invalid "<invalid>" and "<invalidPassword>" information
    Then provide an error message.
    Examples:
      | invalid | invalidPassword |
      | lackoka | dsadsaas        |

  Scenario: Close browser
    Then I close browser