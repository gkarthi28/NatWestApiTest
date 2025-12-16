Feature: Add an  Object to the ProductList
  @test
  Scenario: Verify an item can be created
    Given a "Apple MacBook pro 16" is created
    And is a "Intel Core i9" CPU Model
    And has a price of "1849.99"
    When the request to add the item is made
    Then a 200 response code is returned
    And a "Apple MacBook pro 16" is verified
    And response time should be less than 3 sec


