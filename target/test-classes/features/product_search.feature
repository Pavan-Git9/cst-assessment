Feature: Dynamic Product Search & Cart Verification

  @smoke
  Scenario: Add first matching product to cart and verify
    Given I open the SauceDemo app
    When I login with "standard_user" and "secret_sauce"
    And I search and add a product that matches the keyword
    Then I should see the product in the cart and print its name