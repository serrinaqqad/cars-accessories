Feature: Product Catalog Browsing

  Scenario: Viewing products in a category
    Given the user is on the product catalog page
    When the user selects the "Interior" category
    Then the user should see a list of products related to "Interior" accessories

  Scenario: Product details
    Given the user is on the product catalog page
    When the user selects a product called "Premium Car Seat Covers"
    Then the user should see the details of the "Premium Car Seat Covers"
