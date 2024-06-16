@activity4
  Feature: Data driven test without example
    @loginTest @loginSuccess
    Scenario: testing with correct credentials from inputs
      Given the user is on the login page
      When the user enters "admin" and "password"
      And clicks the login button
      Then get the confirmation text and verify message is "Welcome Back, admin"

    @loginTest @loginFail
    Scenario: testing with wrong credentials from inputs
      Given the user is on the login page
      When the user enters "admin12" and "password12"
      And clicks the login button
      Then get the confirmation text and verify message is "Invalid Credentials"