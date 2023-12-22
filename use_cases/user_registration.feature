Feature: User Registration

  Scenario: Successful registration with valid details
    Given the user is on the registration page
    When the user enters a valid username "newuser", email "newuser@example.com", and password "password123"
    And the user submits the registration form
    Then the user should be registered successfully

  Scenario: Registration with an already taken username
    Given the user is on the registration page
    When the user enters a username "existinguser" that is already taken
    And the user submits the registration form
    Then the user should be informed that the username is already taken
