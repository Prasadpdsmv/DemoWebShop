@reg
@e2e
Feature: ene to end functionality
  Scenario: e2e of user appearl and soes shopping
    Given user is on "Apparel & Shoes" page
    When User selects blue jeans and clicks add to cart
    Then notification added to cart and shoping link will displayed
    When user clicks on shopping link
    Then shopping cart will open
    And user eneters coupon coode and gift card
    And user selects country and state and clicks CheckOut
