Feature: Recover Password

Scenario: Successful passowrd recover by an User
	Given User is on recover page
	When User enters email
	And User clicks on submit button
	Then The password is displayed