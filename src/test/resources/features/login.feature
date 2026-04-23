Feature: Complete Hybrid Testing

Scenario: UI + API validation together
  Given user opens browser
  When user logs in using excel data
  Then login should be successful
  And user validates API response

  Scenario: UI + API validation together
    Given user opens browser
    When user logs in using excel data
    Then login should be successful
    And user validates API response