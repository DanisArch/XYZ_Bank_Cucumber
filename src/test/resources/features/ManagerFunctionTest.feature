Feature: Bank Manager page buttons

  Scenario Outline: Check buttons on Bank Manager page
    Given the user is on the login page
    When the user clicks on the "Bank Manager Login" button
    Then the button '<buttonName>' should be displayed
    Examples:
      | buttonName   |
      | Add Customer |
      | Open Account |
      | Customers    |