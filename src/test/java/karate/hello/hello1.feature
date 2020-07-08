Feature: Hello World

  Background:
    Given url 'http://localhost:8080'
    Given path '/api/hello'

  Scenario: Hello world

    When method GET
    Then status 200
    And match $ == "Hello world!"

  Scenario: Hello with a param

    Given param name = 'Daas'
    When method GET
    Then status 200
    And match $ == "Hello Daas!"