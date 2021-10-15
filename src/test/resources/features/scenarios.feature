Feature: Acceptance Criteria
  Scenario: adding products to the wishlist
    Given I add four different products to my wishlist
    When I view my Wishlist table
    Then I find a total of "4" selected items in my Wishlist
    When I search for lowest price product in the Wishlist
    And I am able to add the lowest price item to my cart from the Wishlist
    Then I am able to verify the item in my cart