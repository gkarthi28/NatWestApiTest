Feature: Return an Item

@test
Scenario: Ability to return an item
 Given a item is created with below specification
  |item|cpumodel|price|harddisksize|year|
  |Apple Ipad|Intel Core 19|"855.78"|"1 TB"|2020|
 And stores the created item id
 When the request to get the single item is made
 Then a 200 response code is returned
 And the details of item matches with created item details
 And response time should be less than 3 sec

 @test
Scenario: Verify that the Api shouldn't return Error When passing Wrong id
 Given the get object url is configured
 When the request to get the single item is made
 Then a 404 response code is returned
 And response should show error message
 And response time should be less than 3 sec


