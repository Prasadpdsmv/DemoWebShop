@book
Feature: ene to end functionality
  Scenario: e2e of user appearl and soes shopping
    Given user is on "Books" page
    When User selects "Health Book" books
    Then notification added to cart and shoping link will displayed
    When user clicks on shopping link
    Then shopping cart will open

  Scenario: e2e of user appearl and soes shopping
    Given user is on "Books" page
    When User selects "Computing and Internet" books
    Then notification added to cart and shoping link will displayed
    When user clicks on shopping link
    Then shopping cart will open