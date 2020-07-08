Feature: Claim Request Handler

    Background:
        Given url baseUrl
        Given path '/api/claim-request'

    Scenario: Create a claim request on a valid Request body
        Given request { name: "Create", additionalNotes: "Some Description",amount: 1000 }
        When method POST
        Then status 200
        And match $ == { name:"Create", additionalNotes: "Some Description",amount: 1000 }

    Scenario: Respond 400 for claim request on invalid Request body
        Given request { name: "Bad Request", additionalNotes: "Some Description",amount: 1000 }
        When method POST
        Then status 400
