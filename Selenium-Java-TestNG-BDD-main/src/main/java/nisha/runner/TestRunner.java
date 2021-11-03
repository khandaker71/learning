package nisha.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = { "src/test/java/nisha/features" }, // feature folder path
		glue = { "nisha.stepDefinations", "nisha.hooks" }, // step definition, hooks folder name
		tags = { "@Signup-DataDriven" }, // what all the tags in feature files need to run
		strict = true,
		// dryRun = true, //to check feature vs step definition mapping is correct. if
		// not available stepdef, it shows on console
		monochrome = true, // to see console output in a clean manner
		snippets = SnippetType.UNDERSCORE, // Generate codSnippet in underscore type. SnippetType.CAMELCASE --> as
											// camelcase style
		plugin = { "pretty", // Better format options for HTML Report
				"html:reports/cucumberHTMLReports", // Generates HTML Report
				"json:reports/cucumberJsonReports.json", // Generate Json Report
				"usage:reports/cucumber-usage.json", "progress:reports/cucumber-progress.txt",
				"junit:reports/cucumberJunitReports.xml", // Generates report in xml file format
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		// "de.monochromata.cucumber.report.PrettyReports:target"
		})
public class TestRunner extends AbstractTestNGCucumberTests {

}

//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest