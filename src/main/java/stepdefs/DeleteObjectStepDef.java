package stepdefs;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ApiUtil;

import static io.restassured.RestAssured.given;

public class DeleteObjectStepDef {
	private Response response;
	@When("^the request to Delete the item is made$")
	public void the_request_to_delete_the_item_is_made() {
		String path = "objects/" + TestContext.get ("id");
		response = ApiUtil.delete (path);
		TestContext.lastResponse = response;
	}
	@Then("^response should show message item deleted successfully$")
	public void a_item_should_be_deleted_successfully(){
		String expectedMessage = "Object with id = " +TestContext.get ("id")+ " has been deleted.";
		Assert.assertEquals (response.body ().jsonPath ().get ( "message" ),expectedMessage);


	}

	@And("^the request to get the deleted item is made$")
	public void theRequestToGetTheDeletedItemIsMade() {
		Response response = ApiUtil.get("objects/" + TestContext.get("id"));
		TestContext.setLastResponse (response);
	}
}
