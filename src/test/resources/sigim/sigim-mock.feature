Feature: Claim Request Handler

  Background:
    Given url 'http://127.0.0.1:9000'
    Given path '/claim-status'

  Scenario: Give the status of the claim Request for valid ID

    When method GET
    Then status 200
    And match $ == "Approved"
