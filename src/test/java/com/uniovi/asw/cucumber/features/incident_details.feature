Feature: Let an operator see incident details
  The operator must belong to the system
  The operator must be logged in the system
  
  Scenario: Let an operator see incident details
    Given an operator logged in the system
    When clicks on incident details button
	Then operator can see details of the incident