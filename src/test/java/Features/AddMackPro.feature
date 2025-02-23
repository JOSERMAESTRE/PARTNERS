Feature: Add MacBook Pro to Cart

  Scenario: User adds a MacBook Pro to the shopping cart
    Given user is on the Laptops & Notebooks page
    When user adds "MacBook Pro" to the cart
    Then user sees a success message
