Feature: Login functionality

  Scenario: Login with valid credentials
    Given user is on login page
    When user logs in with valid credentials
    Then user should see products page
