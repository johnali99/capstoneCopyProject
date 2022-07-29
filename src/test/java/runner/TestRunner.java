package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;


@RunWith(Cucumber.class)
@CucumberOptions(
		//feature tells cucumebr where all feature files are located
		//glue tells cucumber where all step definition classes are located 	
		//tags will run one scenario or multiple scenarios or entire feature
		//dryRun will check if there is any missing step in stepDefinition class for each scenario step in feature file
		//monochrome will make the console readable
		//plugin will be used for generating a readable report
		
		features = "classpath:features",
		glue = "stepDefinition",
		tags = "@RegisterList",	
		dryRun = false,	
		monochrome = true,
		plugin = {"pretty", 
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json" },
		publish = true
		
		)
public class TestRunner {
/*
 * This line of code will invoke the cucumber reporting method once the execution is over
 * @AfterClass annotation is from JUnit and this will run after (AfterHooks)
 * */
	@AfterClass
	public static void generateReport() {
		CucumberReportingConfig.reportConfig();
	}
	
}
