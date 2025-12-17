Feature: List the Items

  @Test
Scenario: Ability to list multiple items
  Given the list of all objects url is configured
  When the request to list all items is made
  Then a 200 response code is returned
  And the response should display multiple items
  And response time should be less than 3 sec
