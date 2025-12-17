Feature: Delete the Object

  @Test
 Scenario: Ability to Delete the Object
   Given a item is created with below specification
     |item|cpumodel|price|harddisksize|year|
     |Apple Ipad|Intel Core 19|"855.78"|"1 TB"|2020|
   And stores the created item id
   When the request to Delete the item is made
   Then a 200 response code is returned
   And response should show message item deleted successfully
   And response time should be less than 3 sec
   And the request to get the deleted item is made
   And  a 404 response code is returned
