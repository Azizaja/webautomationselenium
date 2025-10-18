Feature: Checkout process

  Scenario: Complete a product checkout
    Given user is logged in
    When user adds a product to the cart
    And proceeds to checkout
    And enters valid shipping information
    And completes the purchase
    Then user should see confirmation message
