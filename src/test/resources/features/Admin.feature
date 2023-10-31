Feature: Admin Management

  Scenario: Creating a New Category
    Given the admin is logged in as admin
    When they navigate to the category management section
    And they select "Create New Category" from the menu
    And they enter the category name and description
    And they click "Save"
    Then the new category is added to the list

  Scenario: Editing a Category
    Given the admin is logged in as admin
    When they select an existing category from the menu
    And they select the "Edit" option
    And they modify the category's name or description
    And they select "Save"
    Then the category details are updated

  Scenario: Deleting a Category
    Given the admin is logged in as admin
    When they select a category to delete
    And they select "Delete" option
    And confirm the deletion
    Then the category is removed from the system

  Scenario: Adding a new product
    Given the admin is logged in as admin
    When they go to the product management section
    And they select "add new product"
    And they select a category for the product
    And they enter product name and price
    And then click "save"
    Then the new product is added to the list under it's category

  Scenario: Editing an existing product
    Given the admin is logged in as admin
    When they select an existing product from the menu
    And they select the "Edit" option
    And they modify the products's name or price
    And they select "Save"
    Then the product details are updated

  Scenario: Deleting a product
    Given the admin is logged in as admin
    When they select a product to delete
    And they select "Delete" option
    And confirm the deletion
    Then the product is removed from the system

  Scenario: Creating a New User Account
    Given the admin is logged in as admin
    When they navigate to user account management
    And they select the "Create New User" from the menu
    And they enter user details (username, email, password, user type)
    And they select "Create"
    Then a new user account is created

  Scenario: Editing User Account Information
    Given the admin is logged in as admin
    When they select an existing user account
    And they click on the "Edit" button
    And they modify user account information
    And they select "Save"
    Then the user account details are updated

  Scenario: Deactivating a User Account
    Given the admin is logged in as admin
    When they select a user account to deactivate
    And they click on the "Deactivate" button
    And confirm the deactivation
    Then the user account is deactivated














