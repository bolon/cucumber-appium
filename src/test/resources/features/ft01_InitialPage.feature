Feature: Initial page

Scenario: [1] Make sure elements are visible
    Given I am in Moka App initial page
    Then I will see login button
    And I will see register button

Scenario: [2] Make sure button is clickable
    Given I am in Moka App initial page
    Then I will be able to click login button
    And I will be able to click register button
