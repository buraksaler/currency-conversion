Feature: An example

  Scenario: The example 1
    Given add rate "USD", "JPY", 132.62
    Given add rate "USD", "AUD", 1.40
    Given add rate "JPY", "GBP", 0.0062
    Given add wanted "AUD", "USD", 1.0
    Given expected result 0.71
    When solve the problem
    Then the results match

  Scenario: The example 2
    Given add rate "USD", "JPY", 132.62
    Given add rate "USD", "AUD", 1.40
    Given add rate "AUD", "TRY", 12.79
    Given add rate "EUR", "TRY", 18.58
    Given add rate "JPY", "GBP", 0.0062
    Given add wanted "GBP", "EUR", 1.0
    Given expected result 1.18
    When solve the problem
    Then the results match