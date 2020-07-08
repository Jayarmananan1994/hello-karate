Feature: Claim Request Handler
  Background:
    * def id = 0
    * def claimRequests = {}
  Scenario: pathMatches('/claim-status/{id}') && methodIs('get')
    * def response = "Approved"

  Scenario: pathMatches('/add-claim') && methodIs('post')
    * def claimRequest = request
    * def id = ~~(id + 1)
    * claimRequests.id = id
    * claimRequests[id + ''] = claimRequest
    * def response = claimRequest

  Scenario: pathMatches('/claim/{id}') && methodIs('get')
    * def response = claimRequests[pathParams.id]