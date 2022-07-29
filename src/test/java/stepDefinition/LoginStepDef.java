package stepDefinition;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPageObject;
import utilities.UtilityClass;


public class LoginStepDef extends Base{

	LoginPageObject loginPO = new LoginPageObject();
	
	@Given("^user is on retail website$")
	public void user_is_on_retail_website() {
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "TEK SCHOOL";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		logger.info("Expected title is matching the actual title");
		UtilityClass.takeScreenshot();
	}
	
	@When("^user click on my account$")
	public void user_click_on_my_account() {
		loginPO.clickOnMyAccount();
		logger.info("User clicked on my account");
		UtilityClass.takeScreenshot();
	}
	
	@And("^user click on login option$")
	public void user_click_on_login_option() {
		loginPO.clickOnLogin();
		logger.info("User clicked on Login option");
		UtilityClass.takeScreenshot();
	}
	
	@And("^user enter userName '(.+)' and password '(.+)'$")
	public void user_enter_userName_and_password(String uName, String pass) {
		loginPO.enterEmailAndPassword(uName, pass);
		logger.info("User entered " + uName + " and " + pass);
	}
	
	@And("^user click on login button$")
	public void user_click_on_login_button() {
		loginPO.clickLoginBtn();
	}
	
	@Then("^user should be logged in to my account dashboard$")
	public void user_should_be_logged_in_to_my_account_dashboard() {
			Assert.assertTrue(loginPO.isMyAccountTextPresent());
	}
}
