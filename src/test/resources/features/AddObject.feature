Feature: Add an  Object to the ProductList
  @Test
  Scenario: Verify an item can be created
    Given a "Apple MacBook pro 16" is created
    And is a "Intel Core i9" CPU Model
    And has a price of "1849.99"
    When the request to add the item is made
    Then a 200 response code is returned
    And a "Apple MacBook pro 16" is verified
    And response time should be less than 3 sec


# As there is no Mandatory params for the Api. so we cant check them
  @NoTest
 Scenario Outline: Verify the Mandatory fields of the Add Item Api
    Given a item is created with below specification
      |item|cpumodel|price|harddisksize|year|
      |<item>|<cpuModel>|<price>|<harddisksize>|<year>|
    When the request to add the item is made
    Then a 404 response code is returned
    And response time should be less than 3 sec
     Examples:
       |item|cpuModel|price|harddisksize|year|
       |    |Intel Core i9|200.89|1TB   |2020|
       |Apple MacBook pro 16 |   |300.50| 500MB|2019|
       |Apple MacBook pro 17 |AMD   | | 500MB|2019|
       |Apple MacBook pro 18 |Nvidia   |300.50| |2019|
       |Apple MacBook pro 19 |Nvidia   |300.50|512MB ||