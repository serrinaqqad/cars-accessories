Feature: Reviews and Ratings

  Scenario: Customers leave reviews and ratings for products
    Given the customer is on the product details page for "Smartphone"
    When the customer leaves a review with the title "Great Product" and rating 5
    Then the review and rating should be submitted successfully
    And the product page should display the average rating and reviews count
