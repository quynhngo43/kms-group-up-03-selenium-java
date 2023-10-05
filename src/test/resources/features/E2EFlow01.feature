@E2EFlow1
Feature: Test E2E Flow 01

  Background: Navigate Register Page
    Given user navigate to Register page
    Then page title is "Create Account"

  Scenario Outline: <case> case expectation
    Given user type in the Firstname with value <firstname> Lastname with value <lastname> Telephone with value <telephone> Fax with value <fax> Company with value <company> First Address with value <firstAddress> Second Address with value <secondAddress> City with value <city> ZIP code with value <zip>
    And user click on Agree Policy checkbox
    And user click on "Continue" button
    Then page title is "Your Account Has Been Created!"
    #Logout account
    Given user logout account
    Then page title is "Account Logout"
    #Login again
    And user navigate to Login page
    And user type in the Loginname and Password to login with <validData> data
    And user click on "Login" button
    Then verify that user receive <type> message <message>

    Examples:
      | case  | firstname | lastname | telephone  | fax   | company | firstAddress | secondAddress | city  | zip   | validData | type       | message                                      |
      | Happy | Ngo       | Quynh    | 0987654321 | 10000 | KMS     | A street     | B District    | Login | 10000 | valid     | successful | Welcome back Ngo                             |
      | Error | Ngo       | Quynh    | 0987654321 | 10000 | KMS     | A street     | B District    | Login | 10000 | invalid   | error      | Error: Incorrect login or password provided. |