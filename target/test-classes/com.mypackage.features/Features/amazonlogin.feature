Feature: AmazonLogin

  @DES-5 @OPEN
  @closeBrowser
  Scenario: Amazon login with valid credentials
    Given user enter the "https://www.amazon.com" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides valid credentials as; "demoenvision@gmail.com", "Test"
    #update
    Then user should be able to login to Amazon

  @DES-5 @OPEN
  @closeBrowser
  Scenario: Amazon login with invalid credentials
    Given user enter the "https://www.amazon.com" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides invalid "demoenvision@gmail.com" and "password"
    Then user should not be able to login
    #update via code
    And user should see a "message" about invalid credentials
