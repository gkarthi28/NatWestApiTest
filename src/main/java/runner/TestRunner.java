package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/main/resources/",
		glue= {"stepdefs","hooks"},
		tags = "@Test",
		plugin = {
			"pretty",
			"html:target/cucumber-reports.html",
			"json:target/cucumber-reports.json"
		},
		monochrome = true,
		publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
