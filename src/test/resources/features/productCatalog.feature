Feature: Product Catalog

  Scenario: Creating a New Product Category
    Given the admin is logged in to the admin panel
    When they navigate to product category management
    And they click on the "Create New Category" button
    And they enter the category name and description
    And they click "Save"
    Then a new product category is added to the catalog

  Scenario: Editing a Product Category
    Given the admin is logged in to the admin panel
    When they select an existing product category
    And they click on the "Edit" button
    And they modify the category name or description
    And they click "Save"
    Then the product category details are updated

  Scenario: Deleting a Product Category
    Given the admin is logged in to the admin panel
    When they select a product category to delete
    And they click on the "Delete" button
    And confirm the deletion
    Then the product category is removed from the catalog

  Scenario: Viewing Product Listings
    Given the customer is logged in to the customer portal
    When they browse the product catalog
    Then they can see a list of products with detailed descriptions, images, prices, and availability

  Scenario: Searching for Products
    Given the customer is logged in to the customer portal
    When they use the search feature to look for a specific product
    Then they can see a list of products that match their search query

  Scenario: Filtering Products by Category
    Given the customer is logged in to the customer portal
    When they select a category filter
    Then they can view products belonging to the selected category

  Scenario: Sorting Products by Price
    Given the customer is logged in to the customer portal
    When they choose to sort products by price (ascending or descending)
    Then they see the products arranged according to their selected sorting preference

