Developed an Api Automation Framework for the https://restful-api.dev/

The below Scenarios are Automated.
1) Add Object ::- The below scenarios added to the Add Object Feature file
   1)Verify an item can be created
   2)Verify the Mandatory fields of the Add Item Api 
2) Get Object ::- This Api is used to Fetch the Get Object. The below scenarios added.
   1)Ability to return an item
   2)Verify that the Api should return Error When passing Wrong id
3) Get Objects ::-This Api is used to list all the objects
  1)Ability to list multiple items
4) Delete Object : This Api is used to delete the Object
     1)Ability to Delete the Object


Tools Used ::-
===========
Language : Java 21
Framework : TestNg
Library : RestAssured 

Commands :: mvn clean test
