package stepDefinition;

import java.util.List;
import java.util.Map;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageObject.RegisterPageObject;
import utilities.UtilityClass;

public class RegisterStepDef extends Base{

	RegisterPageObject reg = new RegisterPageObject();
	
	@And("user click on Register")
	public void user_click_on_register() {
		reg.clickRegister();
		logger.info("user is on register page");
		UtilityClass.takeScreenshot();
	}
	@And("user fill registeration form with below information")
	public void user_fill_registeration_form_with_below_information(DataTable dataTable) {   
		List<Map<String, String>> infor = dataTable.asMaps(String.class, String.class);
		List<Map<String, String>> info = dataTable.asMaps(String.class, String.class);
		reg.enterFName(info.get(0).get("firstName"));
		reg.enterLname(info.get(0).get("lastName"));
		reg.enterEmail(info.get(0).get("email"));
		reg.enterPhone(info.get(0).get("telephone"));
		reg.enterPassword(info.get(0).get("password"));
		reg.enterConfirmPass(info.get(0).get("passwordConfirm"));
		reg.susbcription(info.get(0).get("subscription"));
		
		logger.info("user entered information " + info.toString());
		UtilityClass.takeScreenshot();
	}
	@And("user agree to privacy policy")
	public void user_agree_to_privacy_policy() {
	    reg.clickOnPrivacyPolicy();
	    logger.info("User clicked on Privacy Policy checkbox");
	}
	
	@And("user click on continue button")
	public void user_click_on_continue_button() {
		reg.clickContinurBtn();
		logger.info("User clicked on continue button");
	}
	@Then("user should see successfull message {string}")
	public void user_should_see_successfull_message(String string) {
	   Assert.assertEquals(string, reg.sucessMessageVerify());
	   logger.info("Account was created successfully!");
	   UtilityClass.takeScreenshot();
	}
}
