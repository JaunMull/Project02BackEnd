Feature: Login

Scenario: Successful Login by an User
	Given User is on login page
	When User enter "email" and "password"
	And User clicks on Login button
	Then The home page is displayed