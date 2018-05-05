Feature: Let an operator log in the dashboard
  The operator must belong to the system
  Email and password must be correct
  
  Scenario: Let an operator log in
    Given an operator in homepage
    When clicks on log in button
    And fills in correctly email and password
	Then operator is logged in