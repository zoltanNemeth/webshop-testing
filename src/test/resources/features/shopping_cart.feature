Feature: Shopping cart

  Scenario: "As a User,
  I want to have a Shopping Cart
  So that I can ADD products which I want to buy."

    Given I am logged in
    And I have a Product list
    And the Products have an 'Add to cart' button
    When I click on the 'Add to cart' button
    Then ensure it creates a new Order for storing cart data of the User
    And ensure it creates a new LineItem with the quantity and price of the Product
    And ensure it stores this data in the session
    And ensure it displays the number of cart items in the Page header.

  Scenario: "As a User,
  I want to review my Shopping Cart
  So that I can review the items in my shopping cart
  before checking out so that I can see what I've already selected."

    Given I am logged in
    And I have a Shopping Cart with items in it
    When I click on the 'Shopping cart' menu item in the Page header
    Then ensure it displays the items with the following data:
    And ensure it displays the total price of all the items in the cart

