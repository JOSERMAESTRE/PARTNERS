Feature: Add Samsung Galaxy Tablet to Cart

  Scenario: User adds Samsung Galaxy tablet to the cart
    Given user is on the home store page
    When user searches for "Samsung Galaxy Tab 10.1" and adds the first result
    Then the message confirms item is added to the shopping cart
