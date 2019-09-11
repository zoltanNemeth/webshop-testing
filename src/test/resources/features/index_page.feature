Feature: Index page

  Scenario: user sees all the products
    Given I have Products and a Product Category in the application
    When I open the root url
    Then ensure I can see a list of Products
    And ensure that the following details are displayed: productTitle, description, image, price

  Scenario: user filtering products by product categories
    Given I have Products and Product Categories listed on the index page
    When I I click on a Category's title
    Then ensure it displays the Products only in the selected Category

  Scenario: user filtering products by suppliers
    Given I have Products and Suppliers listed on the index page
    When I I click on a Supplier's name
    Then ensure it displays the Products only for the selected Supplier