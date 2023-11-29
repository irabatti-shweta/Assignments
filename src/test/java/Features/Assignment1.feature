Feature: Inbox details
  I want to write scenarios for the gmail inbox features

  Scenario: Login to Gmail account
    Given Open Chrome browser
    And Navigate to Gmail 'https://www.gmail.com'
    When I enter Email 'shwetairabatti99@gmail.com' and click Next
    And I enter Password 'Test@1234' and click Next
    And Click to Not Now
    Then I logged into my Gmail account

