Feature: Complete End-to-End Testing

Scenario: Add and validate employee
  Given user opens browser
  When user logs in using excel data
  Then login should be successful
  When user navigates to PIM module
  And user adds a new employee
  Then employee should be added successfully
  And user validates API response