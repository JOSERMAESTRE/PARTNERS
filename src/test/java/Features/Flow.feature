Feature: Shopping Cart Flow

  Scenario Outline: User performs shopping actions on the website
    Given user visit on the login page
    When user types "<username>" and "<password>" and clicks the login button
    Then user should be redirected to the account dashboard
    When user clicks on "Laptops & Notebooks" and selects "Show All Laptops & Notebooks"
    Then user sees available laptops and notebooks
    When user places "MacBook Pro" in the cart
    Then user receives a confirmation message
    When user looks for "Samsung Galaxy Tab 10.1" and selects the first product
    Then a confirmation message appears indicating the item has been added to the shopping cart
    When user goes to shopping car removes "MacBook Pro" and increases the "Samsung Galaxy Tab 10.1" quantity by 1
    Then Success message is displayed
    When user enters the following billing details:
      | first_name   | last_name   | company   | address1   | address2   | city   | postcode   | country   | region   |
      | <first_name> | <last_name> | <company> | <address1> | <address2> | <city> | <postcode> | <country> | <region> |
    Then message your order has been placed is displayed
    Examples:
      | first_name | last_name | company | address1 | address2 | city       | postcode | country  | region | username              | password |
      | Lito       | Gomez     | Master  | 123 St   | Apt 101  | Valledupar | 20005    | Colombia | Cesar  | litogomez@example.com | 123456   |


