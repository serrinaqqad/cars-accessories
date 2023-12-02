Feature: Notifications

  Scenario: Customer Receives Order Confirmation Email
    Given the customer should see a confirmation message for the order
    Then the customer should receive an order confirmation email

  Scenario: Installer Receives New Installation Request Notification
    Given installation request will be submitted
    Then the installer should receive a notification about the new installation request