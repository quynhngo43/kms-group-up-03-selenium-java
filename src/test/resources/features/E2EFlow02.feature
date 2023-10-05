@E2EFlow2
Feature: Test E2E Flow 02: register, logout, login, search products by categories, add to cart, checkout

  Background: Navigate Register Page
    Given user navigate to Register page
    Then page title is "Create Account"
    And user type in the Firstname as <firstname> Lastname as <lastname> Telephone as <telephone> Fax as <fax> Company as <company> First Address as <firstAddress> Second Address as <secondAddress> City as <city> ZIP code as <zip>
      | firstname | lastname | telephone  | fax   | company | firstAddress | secondAddress | city  | zip   |
      | Ngo       | Quynh    | 0987654321 | 10000 | KMS     | A street     | B District    | Login | 10000 |
    And user click on Agree Policy checkbox
    And user click on "Continue" button
    Then page title is "Your Account Has Been Created!"
    #user log out
    Given user logout account
    Then page title is "Account Logout"
    #user login to existing account
    And user navigate to Login page

  Scenario Outline: Happy case expectations
    And user type in the Loginname and Password to login with <isValid> data
    And user click on "Login" button
    Then verify that user receive <type> message <message>
    #user search product
    Given search product with category "Men" and keywords "Spray"
    And add product "MAN Eau de Toilette Spray" to card
#    And add product "Euphoria Men Intense Eau De Toilette Spray" to card
    And checkout with the shopping cart
    And edit the number of product "MAN Eau de Toilette Spray" to <numberOfProduct>
#    And remove the product "Euphoria Men Intense Eau De Toilette Spray" from cart
    And confirm checkout
    And select Delivery type "Local Delivery"
    And complete order process
    Then verify that order completed with message "Order is completed!"

    Examples:
      | type       | isValid | numberOfProduct | message          |
      | successful | valid   | 2               | Welcome back Ngo |

  Scenario Outline: Error case expectations
    And user type in the Loginname and Password to login with <isValid> data
    And user click on "Login" button
    Then verify that user receive <type> message <message>
    #user search product
    Given search product with category "Men" and keywords "Spray"
    And add product "MAN Eau de Toilette Spray" to card
#    And add product "Euphoria Men Intense Eau De Toilette Spray" to card
    And checkout with the shopping cart
    And edit the number of product "MAN Eau de Toilette Spray" to <numberOfProduct>
#    And remove the product "Euphoria Men Intense Eau De Toilette Spray" from cart
    And confirm checkout
    Then verify that user cannot check out with the message "Products marked with *** are not available in the desired quantity or out of stock!"

    Examples:
      | type       | isValid | numberOfProduct | message          |
      | successful | valid   | 99999           | Welcome back Ngo |