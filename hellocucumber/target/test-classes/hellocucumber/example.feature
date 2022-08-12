Feature: Currency Conversion

  Scenario: AUD to USD
    Given currency rate "USD" to "JPY" is 132.62
    And "USD" to "AUD" is 1.40
    And "JPY" to "GBP" is 0.0062
    And "AUD" to "USD" is 1.0
    When we want 1.0 "AUD" to be converted to "USD"
    Then the result should be 0.71

  Scenario: GBP to EUR
    Given currency rate "USD" to "JPY" is 132.62
    And "USD" to "AUD" is 1.40
    And "AUD" to "TRY" is 12.79
    And "EUR" to "TRY" is 18.58
    And "JPY" to "GBP" is 0.0062
    When we want 1.0 "GBP" to be converted to "EUR"
    Then the result should be 1.17