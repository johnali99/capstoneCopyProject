package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LoginPageObject extends Base{
	//In this class we will store web elements of the login page
	//We will implement PageFactory.initElement method to initialize the page element 
	//We will use @FindBy annotation to store UI Web element
	//We will store UI elements in private webElements and access them
	//Through public keyword, we will write the function inside the public methods
	
	public LoginPageObject() {
		PageFactory.initElements(driver, this);
		//PageFactory class provides an annotation called @FindBy to find UI Elements
		//@FindBy annotation is == to driver.findElemnt(By...);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Login;
	@FindBy(id="input-email")
	private WebElement email;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountText;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}	
	public void clickOnLogin() {
		Login.click();
	}
	public void enterEmailAndPassword(String emailValue, String passwordValue) {
		email.sendKeys("wida@gmail.com");
		password.sendKeys("123456");	
	}
	public void clickLoginBtn() {
		loginBtn.click();
	}
	public boolean isMyAccountTextPresent() {
		if(myAccountText.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
}
