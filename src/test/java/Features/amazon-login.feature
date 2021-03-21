Feature Login functionality of Amazon.com

  Scenario: Login with valid credentials
    Given user enter the "Amazon" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides valid "username" and "password"
    Then user should be able to login to Amazon


  Scenario: Login with invalid credentials
    Given user enter the "Amazon" URL
    And click on Sign in button
    Then Amazon login page is opened
    When user provides invalid "username" and "password"
    Then user should stay on the Amazon login page
    And user should see a "message" about invalid credentials