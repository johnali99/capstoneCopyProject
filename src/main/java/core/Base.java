package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	
	private String propertyPath = ".\\src\\test\\resources\\input\\property.properties";
	private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";

	public Base() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyPath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		logger = logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4jPath);
		
	}
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public static void openBrowser() {
		driver.get(getUrl());
	}
	
	public static void tearDown() {
		//if driver.close() or driver.quit() returns null, we should downgrade the following dependency in pom 
		//to 4.1.1
		//<dependency>
			//<groupId>org.seleniumhq.selenium</groupId>
			//<artifactId>selenium-java</artifactId>
			//<version>4.1.1</version>
		//</dependency>
		
		driver.close();
		driver.quit();
	}
	
	public static void browser() {
		String browserName = getBrowser();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().deleteAllCookies();
	}
	
}
