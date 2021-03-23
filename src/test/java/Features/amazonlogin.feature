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
    And user should see a "message" about invalid credentials

  @DES-17 @OPEN
  Scenario: Duumy Test
    Given user enter the "https://www.amazon.com" URL
    When dummy

  @DES-5 @OPEN
  Scenario: HelloWorld
    Given This is a test
    When I see HelloWorld
    Then Yeeyyy!!!
