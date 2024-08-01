 Feature: Login page 
 
 Scenario: Verify Login with Invalid credential
	Given Should be install and open the app
	And Give allow all rquire access
	When Enter unregisterd mobile number
	And Coninue button tap after unregistered mobile number
	Then Registerd info pop should be come
	And Close pop message 
	
	Scenario: verify update number and Continue as gest Functionality.
	When Tap Coninue button enter after unregistered mobile number
	And Tap Update number button
	Then Verify all detail given on this page
	And Tap on Back from details verify
	And Tap Coninue button enter after unregistered mobile number
	And Tap Continue as gest button
	And Tap Back from Welcome! page 