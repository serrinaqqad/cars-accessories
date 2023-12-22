Feature: Admin Dashboard Management

  Scenario: Manage Product Categories
    Given the admin is on the Admin Dashboard
    When the admin adds a new product category with name "Electronics"
    Then the new product category should be added successfully

    Given the admin is on the Admin Dashboard
    When the admin edits the product category with name "Electronics" to "Electronic Devices"
    Then the product category should be updated successfully

    Given the admin is on the Admin Dashboard
    When the admin deletes the product category with name "Electronic Devices"
    Then the product category should be deleted successfully
