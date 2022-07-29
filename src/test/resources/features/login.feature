Feature: Login to retail website

Background: 
		Given user is on retail website
		When user click on my account
@SmokeTest
Scenario: Retail website login test

	And user click on login option
	And user enter userName 'wida@gmail.com' and password '123456'
	And user click on login button
	Then user should be logged in to my account dashboard

@endToendTest
Scenario Outline: Retail website with multiple accounts

	And user click on login option
	And user enter userName '<userName>' and password '<password>'
	And user click on login button
	Then user should be logged in to my account dashboard
	
		Examples:
		|userName							|password|
		|wida@gmail.com				|123456|
		|hawks@tekschool.us		|hawks|
		|eagles@tekschool.us	|eagles|

Scenario: Retail website logout test

	Then user click on logout option