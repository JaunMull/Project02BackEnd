Feature: Sign Up

Scenario: Successful Sign Up by an User
	Given User is on sign up page
	When User enters name  and phone 
	And User enters  email and password
	And User clicks on submit button
	Then The login page is displayed