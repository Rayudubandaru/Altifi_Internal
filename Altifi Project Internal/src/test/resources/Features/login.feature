Feature: Launch the internal application with Valid credentials

  Scenario: Open the altifi internals  page
    Given Launch the browser and open application
    When valid url and password
    Then click on login button and validate logout ensure we are in
