Feature: login page

  Scenario Outline: navigate to the login page
    Given user opens the login page
    When user enter "<username>" and "<password>" and user click on the login button
    Then user should see the account page
    Examples:
      | username              | password |
      | litogomez@example.com | 123456   |