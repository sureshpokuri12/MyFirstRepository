package MyStepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/MyFeatureFiles", // Path to feature files
		glue = "MyStepDefs", // Path to step definitions package
		tags="@sanity or @regression",
		//tags = "@regression", 
		plugin = { "pretty", 
				"html:target/my-cucumber-reports.html" ,
				"json:target/CucumberReposts/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // Generates  HTML reports
																										
		// tags="not @skip",// This will exclude scenarios with @skip
		// tags = "@NewCustomerTest", // Runs only scenarios with this tag
		monochrome = false)

public class TestRunner {

}
