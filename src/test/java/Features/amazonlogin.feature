Feature: AmazonLogin

  @DES-5 @OPEN
  Scenario: Amazon login with valid credentials
    Given user enter the "Amazon" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides valid "username" and "password"
    Then user should be able to login to Amazon
