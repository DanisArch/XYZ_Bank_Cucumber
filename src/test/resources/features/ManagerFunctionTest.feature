Feature: Bank Manager page

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

  Scenario: Open new Pound account for Albus Dumbledore and verify
    Given the user is on the login page
    When the user clicks on the "Bank Manager Login" button
    And the User clicks on the "Open Account" button
    And the user selects "Albus Dumbledore" from the customer dropdown
    And the user selects "Pound" from the currency dropdown
    And the User clicks on the "Process" button
    Then the alert message should contain "Account created successfully"
    When the user logs out and returns to the login page
    And the user clicks on the "Customer Login" button
    And the user selects "Albus Dumbledore" from the user dropdown
    And the user clicks on the Login button
    Then the account dropdown should contain an account in Pound