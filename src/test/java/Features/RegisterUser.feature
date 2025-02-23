Feature: User Registration

  Scenario Outline: User successfully registers with valid details
    Given user navigates to the registration page
    When user fills the registration form with the following data:
      | firstName   | lastName   | email   | phone   | password   | confirmPassword   | subscribe   | policy   |
      | <firstName> | <lastName> | <email> | <phone> | <password> | <confirmPassword> | <subscribe> | <policy> |
    Then Page shows a success message
    Examples:
      | firstName | lastName | email            | phone     | password | confirmPassword | subscribe | policy |
      | lito      | gomez    | litov@example.com | 323199312 | 123456   | 123456          | si        | si     |

       