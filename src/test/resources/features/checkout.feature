Feature: Checkout

  Scenario Outline: As a User,
  I want to checkout the items from the Shopping Cart
  So that I can order the Products.

    Given a user is logged in
    And I have items in the shopping cart
    Given I have a Shopping Cart review page
    When I click on the Checkout button
    Then I fill the "<Name>" and "<Email>" and "<Phone number>" and "<Country>" and "<City>" and "<Zip>" and "<Billing Adress>"
    And I click on the submit button
    And it stores the validated data to the Order
    Then it redirects to the Payment page

    Examples:

      | Name       | Email               | Phone number | Country | City     | Zip  | Billing Adress             |
      | Pelda Jani | example@example.com | +123456789   | Hungary | Budapest | 1111 | Budapest Example street 1. |
      |  | exampleexample.com | abcd   | Hungary | Budapest | 1111 | Budapest Example street 1. |
      | Pelda Jani | @example.com | +1234őáű789   | Hungary | Budapest | 1111 | Budapest Example street 1. |
      | Pelda Jani | example@.com |    | Hungary | Budapest | 1111 | Budapest Example street 1. |
      | Pelda Jani |   | +123456789   | Hungary | Budapest | 1111 | Budapest Example street 1. |




  Scenario: As a User,
  I want to pay for my Products
  So that I can complete the payment online.

    Given I checked-out the items from the Shopping cart
    Then I can see the total price what I have to pay
    And I can choose from the following payment methods credit card and paypal
    Then based on the selected payment method I can enter enter the credentials for the payment provider:


