package stepdefs;

import context.TestContext;
import dtos.Item;
import dtos.ProductData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ApiUtil;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetObjectStepDef {
	private Response response;
	private Response getResponse;
	@Given("^a item is created with below specification$")
	public void a_item_is_created_with_below_specification(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps (String.class,String.class);
		  Item item = new Item (  );
		  ProductData productData = new ProductData (  );
		  item.setName (data.getFirst ().get("item"));
		  productData.setCpuModel (data.getFirst ().get("cpumodel"));
		  productData.setHardDiskSize (data.getFirst ().get ("harddisksize"));
		  productData.setPrice (data.getFirst ().get("price"));
		  productData.setYear (Integer.parseInt (data.getFirst ().get("year")));
		  item.setData (productData);
		  response  = ApiUtil.post ("objects",item,ContentType.JSON);
          TestContext.setLastResponse (response);
	}
	@Given("^stores the created item id$")
	public void a_item_has_a_id_id() {
        // Get the id from Context
		JsonPath jsonBody =response.getBody ().jsonPath ();
		TestContext.set ("id",jsonBody.get("id"));
		TestContext.set ("name",jsonBody.get("name"));
		TestContext.set ("cpu_model", jsonBody.get ("data.cpuModel" ));
		TestContext.set ("price", jsonBody.get ("data.price" ));
		TestContext.set ("year", String.valueOf (jsonBody.getInt ("data.year" )));
		TestContext.set ("harddisksize", jsonBody.get ("data.hardDiskSize" ));
	}
	@When("^the request to get the single item is made$")
	public void the_request_to_get_the_single_item_is_made() {
		String path = "objects/" + TestContext.get("id");
		getResponse = ApiUtil.get ( path);
        TestContext.lastResponse= getResponse;
	}
	@Then("^the details of item matches with created item details$")
	public void the_details_of_item_matches_with_created_item() {
		JsonPath jsonBody = getResponse.getBody ().jsonPath ();
		Assert.assertEquals (jsonBody.getString ("id"),TestContext.get("id"));
		Assert.assertEquals (jsonBody.getString ("name"),TestContext.get("name"));
		Assert.assertEquals (jsonBody.getString ("data.year"),TestContext.get("year"));
		Assert.assertEquals (jsonBody.getString ("data.price"),TestContext.get("price"));
		Assert.assertEquals (jsonBody.getString ("data.cpuModel"),TestContext.get("cpu_model"));
		Assert.assertEquals (jsonBody.getString ("data.hardDiskSize"),TestContext.get("harddisksize"));


	}


	@Given("^the get object url is configured$")
	public void theGetObjectUrlIsConfigured() {
		TestContext.set ("id","2056");
		TestContext.set("path", "objects/"+TestContext.get ("id"));
	}

	@And("^response should show error message$")
	public void responseShouldShowErrorMessage() {
		String expectedMessage = "Oject with id=" +TestContext.get ("id")+ " was not found.";
		Assert.assertEquals (getResponse.jsonPath ().get ( "error" ),expectedMessage);

	}

}
