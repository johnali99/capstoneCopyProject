package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class RegisterPageObject extends Base{

	public RegisterPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(css="#input-lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement phone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter' and @value=1]")
	private WebElement yesSubscriptionBtn;
	
	@FindBy(xpath="//input[@name='newsletter' and @value=0]")
	private WebElement noSubscriptionBtn;
	
	@FindBy(xpath="//input[@name='agree' and @value=1]")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement successMsg;
	
	public void clickRegister() {
		register.click();
	}
	
	public void enterFName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLname(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String e_mail) {
		email.sendKeys(e_mail);
	}
	
	public void enterPhone(String phoneValue) {
		phone.sendKeys(phoneValue);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPass(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}
	
	public void susbcription(String value) {
		if(value.equalsIgnoreCase("Yes") && !yesSubscriptionBtn.isSelected()) {
			yesSubscriptionBtn.click();
		} else if(value.equalsIgnoreCase("No") && !noSubscriptionBtn.isSelected()) {
			noSubscriptionBtn.click();
		}
	}
	
	public void clickOnPrivacyPolicy() {
		if(!privacyPolicy.isSelected()) {
			privacyPolicy.click();
		}
	}
	
	public void clickContinurBtn() {
		continueBtn.click();
	}
	
	public String sucessMessageVerify() {
		return successMsg.getText();
	}
	
}
