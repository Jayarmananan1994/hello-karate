Feature: Claim Request Handler

  Background:
    Given url 'http://sigim-service.com'
    Given path '/claim-status/'

  Scenario: Create a claim request on a valid Request body
    Given path 100
    When method GET
    Then status 200
    And match $ == "Approved"
