# Create Item Feature
# Tags: Item
    
Feature: Create Item in lib
    
Scenario: [1] Make sure create button is exist
    Given I am in Moka App initial page
    Then I will go to "Sign In" page
    When I am in login page
    Then I will enter valid credential
    When I click "Sign In" button
    Then I will be on choosing outlet page
    Then I will choose outlet on position number 1
    When I click "Continue" button


