Feature: Reset Password

  Scenario Outline: User resets password
    Given user is on the login page
    When user click forgotten pasword link and requests a password reset for "<email>"
    Then user sees a confirmation message
    Examples:
      | email                 |
      | litogomez@example.com |
