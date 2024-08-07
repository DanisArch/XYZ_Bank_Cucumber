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


  Scenario: Add a new customer and verify
    Given the user is on the login page
    When the user clicks on the "Bank Manager Login" button
    And the user clicks on the Add Customer button
    And the user enters "Lord" as first name, "Voldemort" as last name, "L666VM" as post code
    And the user clicks on the Add Customer form button
    Then the alert message should be "Customer added successfully with customer id :<id>"
    When the user clicks on the Customers button
    Then the table should contain a customer with first name "Lord" and last name "Voldemort"