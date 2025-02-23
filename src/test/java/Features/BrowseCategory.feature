Feature: Browse Laptops & Notebooks

  Scenario: User selects "Show all laptops & notebooks"
    Given user is on the homepage
    When user navigates to "Laptops & Notebooks" and selects "Show All Laptops & Notebooks"
    Then user sees all available laptops and notebooks

