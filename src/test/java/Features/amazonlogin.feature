Feature: AmazonLogin

  @DES-5 @closeBrowser @OPEN
  Scenario: Amazon login with valid credentials (NEW)
    Given user enter the "https://www.amazon.com" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides valid credentials as; "demoenvision@gmail.com", "Testuser.1"
    Then user should be able to login to Amazon

  @DES-5 @closeBrowser @OPEN
  Scenario: Amazon login with invalid credentials (NEW)
    Given user enter the "https://www.amazon.com" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides invalid "demoenvision@gmail.com" and "password"
    Then user should not be able to login
    # update via code
    And user should see a "message" about invalid credentials
