package stepdefs;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.ApiUtil;

import static io.restassured.RestAssured.given;

public class GetAllObjectsStepDef {
	private RequestSpecification requestSpecification;
	private Response response;

	@Given("the list of all objects url is configured")
	public void the_list_of_all_objects_url_is_configured() {
		 requestSpecification =given()
				 .baseUri (ApiUtil.BASE_URI)
				 .basePath ("objects");
	}
	@When("^the request to list all items is made$")
	public void the_request_to_list_all_items_is_made(){
		response = requestSpecification.get ();
		TestContext.lastResponse= response;
	}
	@Then("the response should display multiple items")
	public void the_response_should_display_multiple_items() {
		Assert.assertTrue (response.getBody ().jsonPath ()
				 .getList ("").size () > 1);
	}


}
