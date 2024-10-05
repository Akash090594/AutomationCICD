
@tag
Feature: Purchase the order from Ecommerce website.
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of the submit order
    Given Logged in with the username <name> and password <password>.
    When I add product <productName> to cart
    And Checkout <productName> and submit the order.
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

    Examples: 
      | name             | password     | productName     |
      | shetty@gmail.com | Iamking@000  | ADIDAS ORIGINAL |
 