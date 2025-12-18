package stepdefs;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import dtos.Item;
import dtos.ProductData;
import org.testng.Assert;
import utils.ApiUtil;

public class AddObjectStepDef {
	private final Item item;
	private final ProductData productData;
	private Response response;

	public AddObjectStepDef() {
		item = new Item ( );
		productData = new ProductData ( );
	}

	@Given("a {string} is created")
	public void a_is_created(String _item) {
		item.setName (_item);
	}

	@Given("is a {string} CPU Model")
	public void is_a_cpu_model(String cpuModel) {
		productData.setCpuModel (cpuModel);
		item.setData (productData);
	}

	@Given("has a price of {string}")
	public void has_a_price_of(String price) {
		productData.setPrice (price);
		item.setData (productData);

	}

	@When("the request to add the item is made")
	public void the_request_to_add_the_item_is_made() {
		response = ApiUtil.post ("objects",item,ContentType.JSON);
		TestContext.lastResponse= response;
	}

	@Then("a {string} is verified")
	public void item_is_created(String item) {
		Assert.assertEquals (response.jsonPath ( ).getString ("name"), item);
	}

}
