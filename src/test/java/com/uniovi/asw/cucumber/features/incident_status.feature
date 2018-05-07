Feature: Let an operator change incident status
  The operator must belong to the system
  The operator must be logged in the system
  
  Scenario: Let an operator modify incident status to open
    Given an operator logged in the system
    And one assigned incident
    When clicks on incident change status button
    And changes the incident status to open
	Then the incident is open
	
  Scenario: Let an operator modify incident status to in process
    Given an operator logged in the system
    And one assigned incident
    When clicks on incident change status button
    And changes the incident status to in process
	Then the incident is in process
	
  Scenario: Let an operator modify incident status to closed
    Given an operator logged in the system
    And one assigned incident
    When clicks on incident change status button
    And changes the incident status to closed
	Then the incident is closed
	
  Scenario: Let an operator modify incident status to cancelled
    Given an operator logged in the system
    And one assigned incident
    When clicks on incident change status button
    And changes the incident status to cancelled
	Then the incident is cancelled