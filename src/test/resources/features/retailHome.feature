Feature: Register new user


@RegisterList
Scenario: Create new user account in Test Environment
		Given user is on retail website
		When user click on my account
		And user click on Register
		And user fill registeration form with below information
		|firstName|lastName|email|telephone|password|passwordConfirm|subscription|
		|Alex|Connor|aliiii@gmail.com|8979457987|wrongPass|wrongPass|yes|
		And user agree to privacy policy
		And user click on continue button
		Then user should see successfull message 'Your Account Has Been Created!'