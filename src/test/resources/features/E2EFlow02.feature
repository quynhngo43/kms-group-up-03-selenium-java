@E2EFlow2
Feature: Test E2E Flow 02: register, logout, login, search products by categories, add to cart, checkout
  Background: Navigate Register Page
    Given user navigate to Register page
    Then page title is "Create Account"

  Scenario Outline: Happy case expectations
    And user type in the Firstname with value <firstname> Lastname with value <lastname> Telephone with value <telephone> Fax with value <fax> Company with value <company> First Address with value <firstAddress> Second Address with value <secondAddress> City with value <city> ZIP code with value <zip>
    And user click on Agree Policy checkbox
    And user click on Continue button
    Then page title is "Your Account Has Been Created!"

    Given user logout account
    Then page title is "Account Logout"

    And user navigate to Login page
    And user type in the Loginname and Password to login
    And user click Login button to login

    Given search product with category "Men" and keywords "Spray"
    And add product "MAN Eau de Toilette Spray" to card
    And add product "Euphoria Men Intense Eau De Toilette Spray" to card
    And checkout with the shopping cart
    And edit the number of product "MAN Eau de Toilette Spray" with number of product 2
    And remove the product "Euphoria Men Intense Eau De Toilette Spray" from cart
    And confirm checkout
    And select Delivery type "Local Delivery"
    And complete order process
    Then verify that order completed

    Examples:
      | firstname | lastname | telephone  | fax   | company | firstAddress | secondAddress | city  | zip   |
      | Ngo       | Quynh    | 0987654321 | 10000 | KMS     | A street     | B District    | Login | 10000 |

  Scenario Outline: Error case expectations
    And user type in the Firstname with value <firstname> Lastname with value <lastname> Telephone with value <telephone> Fax with value <fax> Company with value <company> First Address with value <firstAddress> Second Address with value <secondAddress> City with value <city> ZIP code with value <zip>
    And user click on Agree Policy checkbox
    And user click on Continue button
    Then page title is "Your Account Has Been Created!"

    Given user logout account
    Then page title is "Account Logout"

    And user navigate to Login page
    And user type in the Loginname and Password to login
    And user click Login button to login

    Given search product with category "Men" and keywords "Spray"
    And add product "MAN Eau de Toilette Spray" to card
    And add product "Euphoria Men Intense Eau De Toilette Spray" to card
    And checkout with the shopping cart
    And edit the number of product "MAN Eau de Toilette Spray" with number of product 99999
    And remove the product "Euphoria Men Intense Eau De Toilette Spray" from cart
    And confirm checkout
    Then verify that user cannot check out with the message "Products marked with *** are not available in the desired quantity or out of stock!"

    Examples:
      | firstname | lastname | telephone  | fax   | company | firstAddress | secondAddress | city  | zip   |
      | Ngo       | Quynh    | 0987654321 | 10000 | KMS     | A street     | B District    | Login | 10000 |


