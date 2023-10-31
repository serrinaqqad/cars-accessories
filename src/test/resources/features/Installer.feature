Feature: Installer Tasks

  Scenario: Viewing Pending Requests
    Given the installer is logged in to their installer portal
    When they see a list of pending installation requests
    And they click on a request to view details
    Then they can see the request details

  Scenario: Accepting a Request
    Given the installer is logged in to their installer portal
    When they select a pending request
    And they click on the "Accept" button
    And propose an appointment date and time
    Then the appointment is scheduled

  Scenario: Rejecting a Request
    Given the installer is logged in to their installer portal
    When they select a pending request
    And they click on the "Reject" button
    And provide a reason for rejection
    Then the request is marked as rejected
