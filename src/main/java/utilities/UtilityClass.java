package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import core.Base;

public class UtilityClass extends Base{

	public static String screenshotName() {
		
		Date date = new Date();
		String screenshot = date.toString().replace(":", "_").replace(" ", "_");
		return screenshot;
	}
	
	public static void takeScreenshot() {
		String location = System.getProperty("user.dir") + "\\output\\screenshots";
		String screenshotFileName = screenshotName()+".png";
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(location + screenshotFileName));
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Eception in Execution");
		}
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public static void switchToWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator =  windowHandles.iterator();
		String window = iterator.next();
		driver.switchTo().window(window);
	}
	
	public static void clearTextUsingKeys(WebElement ele) {
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.DELETE);
	}
	
	public static void clearText(WebElement ele) {
		ele.clear();
	}
	
	public static void scrollPageDownWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void clickElementWithJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("argument[0].click()", element);
	}
	
	public static void sendKeyWithJS(String element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeAsyncScript("document.getElementById('" + element + "').value='" + value + "'");
	}
	
	public static void selectCalenderDateWithJS(WebElement element, String date) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeAsyncScript("argument[0].setAttribute('value','"+ date +"');", element);
	}
	
	public static String getText(WebElement element) {
		String elementText = element.getText();
		return elementText;
	}
	
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
