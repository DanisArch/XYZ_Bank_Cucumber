Feature: Account page options

  @positive
  Scenario: Customer account replenishment test
    Given the user is on the login page
    When the user clicks on the "Customer Login" button
    Then the user should be redirected to the "Customer Login" page
    When the user selects "Harry Potter" from the user dropdown
    And the user clicks on the Login button
    Then the user should be redirected to the Account page
    When user clicks on the "Deposit" button
    Then user should be redirected to the "Deposit" page
    When the user enters the "amount" to be deposited
    And the user clicks on the Deposit button
    Then system deposit confirmation

  @positive
  Scenario: Withdrawl of funds from the account of the user Harry Potter
    Given the user is on the login page
    When the user clicks on the "Customer Login" button
    Then the user should be redirected to the "Customer Login" page
    When the user selects "Harry Potter" from the user dropdown
    And the user clicks on the Login button
    Then the user should be redirected to the Account page
    When user clicks on the "Deposit" button
    Then user should be redirected to the "Deposit" page
    When the user enters the "amount" to be deposited
    And the user clicks on the Deposit button
    And user clicks on the "Withdrawl" button
    Then user should be redirected to the "Withdrawl" page
    When the user enters the "amount" to be withdrawed
    And the user clicks on the Withdraw button
    Then system withdraw confirmation

@negative
  Scenario: Withdrawl of money from the account of the user Harry Potter loss exceeding the balance
    Given the user is on the login page
    When the user clicks on the "Customer Login" button
    Then the user should be redirected to the "Customer Login" page
    When the user selects "Harry Potter" from the user dropdown
    And the user clicks on the Login button
    Then the user should be redirected to the Account page
    When user clicks on the "Withdrawl" button
    Then user should be redirected to the "Withdrawl" page
    When the user enters a large the "amount" to be withdrawed
    And the user clicks on the Withdraw button
    Then system negative withdraw confirmation