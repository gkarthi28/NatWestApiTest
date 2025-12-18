package stepdefs;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CommonStepDef {

	@Then("a {int} response code is returned")
	public void a_response_code_is_returned(int statusCode) {
		Assert.assertEquals (TestContext.lastResponse.getStatusCode ( ), statusCode);
	}

	@And("response time should be less than {int} sec")
	public void responseTimeShouldBeLessThanMs(int time) {
		Assert.assertTrue (TestContext.lastResponse.getTimeIn (TimeUnit.SECONDS) < time);
	}
}
