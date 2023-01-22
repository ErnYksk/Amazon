Feature: Login functionality

  @Smoke
  Scenario: Login with valid username and password

    Given Navigate to Amazon
    When Enter username and password and click login button
    Then User should be login successfully


    @Smoke
    Scenario: User should not be able to login with invalid username and password
      Given Navigate to Amazon
      When Enter invalid username and password
      Then User should not be able to login