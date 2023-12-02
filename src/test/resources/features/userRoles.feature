Feature: User Roles

  Scenario: Admin product management
    Given user is an admin
    And user is on the add product page
    When user enters product "headrest", "exterior", "toyota head pillows size 30cm*50cm" and 42.0
    Then new product should be added to the system

Scenario Outline: Admin updates or deletes product
    Given user is an admin
    And user is on product menu
    When user selects <menuOption> from the menu
    And user <action> product from system
    Then the product should be <verification>

Examples:
  | menuOption | action         | name            | category | description                           | price | verification        |
  | 1          | clicks update  | "headrest"      | "exterior"| "toyota head pillows size 30cm*50cm" | 45.0 | updated successfully |
  | 1          | clicks delete  | ""              | ""       | ""                                    | 0.0  | removed from system  |


  Scenario: Admin deletes a category
    Given user is an admin
    And user is on category menu
    When user selects a "interior" from the menu
    And user confirms category deletion
    Then category and all related products will be deleted from the system

  Scenario: Admin deletes user account
    Given user is an admin
    And user is on user management section
    When admin selects a 2 from the menu
    And user confirms user deletion
    Then user account will be deleted

  Scenario: Customer makes purchase
    Given user is a customer
    And user is on the browse products menu
    When user selects a 1 from the list
    And clicks on order product
    Then the customer should see a confirmation message for the order

  Scenario: Customer views orders
    Given user is a customer
    When user navigates to view orders menu
    Then user will see all previous orders

  Scenario: Installer accepts installation request
    Given user is an installer
    And user is in the installation request menu
    When user selects a 1 from the menu
    And user accepts installation request
    Then the request is added to installers appointments

  Scenario: Installer declines installation request
    Given user is an installer
    And user is in the installation request menu
    When user selects a 1 from the menu
    And user declines installation request
    Then the request will be deleted
