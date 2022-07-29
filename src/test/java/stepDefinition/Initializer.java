package stepDefinition;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.CucumberReportingConfig;

public class Initializer extends Base{

	@Before
	public void beforeHookS(Scenario scenario) {
		System.out.println("Scenario " + scenario.getName() + " started");
		browser();
		openBrowser();
	}
	
	@After
	public void afterHooks(Scenario scenario) {
		tearDown();
		System.out.println("Scenario " + scenario.getName() + " " +scenario.getStatus());
		CucumberReportingConfig.reportConfig();
	}
}
