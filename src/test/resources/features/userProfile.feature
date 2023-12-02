Feature: User Profile

  Scenario Outline: Customer Edits Profile
    Given the user is a customer
    When the user navigates to the Edit Profile section
    And updates contact information with new "newemail@example.com", "+1234567890" and "123 New Street, City"
    And user selects <"option">
    Then the users profile should be <result>

    Examples: 
      | option | result  |
      | y      | updated |
      | n      | kept    |

  Scenario: Customer Views Order History
    Given the user is a customer
    When the user navigates to the Order History section
    Then the user should see a list of past orders

  Scenario: Customer Views Installation Requests
    Given the user is a customer
    When the user navigates to the Installation Requests section
    Then the user should see a list of past installation requests
