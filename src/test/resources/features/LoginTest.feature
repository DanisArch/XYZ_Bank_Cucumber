Feature: Select login right in XYZ Bank

  @smoke
  Scenario: Login as customer
    Given the user is on the login page
    When the user clicks on the "Customer Login" button
    Then the user should be redirected to the "Customer Login" page

  @smoke
  Scenario: Login as bank manager
    Given the user is on the login page
    When the user clicks on the "Bank Manager Login" button
    Then the user should be redirected to the "Bank Manager Login" page

