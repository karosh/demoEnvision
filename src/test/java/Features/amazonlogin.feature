Feature: AmazonLogin

  @DES-5 @OPEN
  Scenario: Amazon login with valid credentials
    Given user enter the "https://www.amazon.com" URL
    And click on Sign in
    Then Amazon login page is opened
    When user provides valid credentials as; "demoenvision@gmail.com", "Test"
    #update
    Then user should be able to login to Amazon
