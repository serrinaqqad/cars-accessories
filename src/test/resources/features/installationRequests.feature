Feature: Installation Requests

  Scenario Outline: Installation Request with Installer Selection
    Given the user is a customer
    And the user is on the request installation menu
    When the user selects 1 from the menu
    And the user enters "Toyota Camry" and preferred date "2023-12-01"
    Then the user can see <availability_message>

    Examples: 
      | availability_message                          |
      | the list of available installers is displayed |
      | no installers available, view available dates |

  Scenario: complete installation request
    Given the user can see the list of available installers is displayed
    When user selects installer 1 from menu
    Then installation request will be submitted

  Scenario: installation request cancel
    Given the user can see no installers available, view available dates
    When user selects installer "yes" from menu
    Then installation request will be canceled
