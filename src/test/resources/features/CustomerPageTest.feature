Feature: Customer login

  Scenario: Login as Harry Potter
    Given the user is on the login page
    When the user clicks on the "Customer Login" button
    And the user selects "Harry Potter" from the user dropdown
    And the user clicks on the Login button
    Then the user should be redirected to the "Account" page