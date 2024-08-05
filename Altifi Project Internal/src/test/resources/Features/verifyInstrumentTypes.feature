Feature: Altifi Internal screen

  Scenario: Verify instrument types
    Given Launch the altifi internal screen
    When Verify the instruments types
    Then Validate instrument name and count
