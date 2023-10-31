Feature: Customer Interaction

  Scenario: Viewing Available Products
    Given the customer is logged in to the customer portal
    When they browse the list of available products
    And they click on a product to view its details
    Then they can see the product details

  Scenario: Filtering Products by Category
    Given the customer is logged in to the customer portal
    When they apply a category filter
    Then they can view products belonging to the selected category

  Scenario: Making a Purchase
    Given the customer is logged in to the customer portal
    When they browse the list of available products
    And they add products to their shopping cart
    And they proceed to the cart for checkout
    And they provide shipping and payment information
    And they confirm the purchase
    Then an order is created, and the products are marked as sold

Scenario: Viewing Order History
    Given the customer is logged in to the customer portal
    When they access their order history
    Then they see a list of past orders