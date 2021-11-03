package nisha.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

import nisha.utility.PropertyHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

/** 
 * Represents a initial setting of testing.
 * This class is basically used for following activities
 * 1. Setup the browser type
 * 2. Collect application URL based environment
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class DriverFactory {

	public static String baseUrl;

	public static WebDriver driver;
	
	// public static Logger log = LogManager.getLogger(DriverFactory.class.getName());

	/**
	 * This method helps to choose browser type and inital browser setings.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return It does not return anything
	 * @throws Exception -> Exception caller to handle the exception
	 */
	public static void setBrowserDriver() throws Exception {
		//load the property and get values
		PropertyHelper.initProperty();
		String browser = PropertyHelper.getProperty("browser");
		String headless = PropertyHelper.getProperty("headless");

		if (browser.equalsIgnoreCase("chrome")) {

			// To handle HTTPS certificates
			ChromeOptions chromOption = new ChromeOptions();
			chromOption.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			chromOption.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			if (headless.contains("true")) {
				chromOption.addArguments("--headless");
			}
			
			//Initialize the Google Chrome driver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromOption);
			
		} else if (browser.equals("firefox")) {
			
			//Initialize the Firefox driver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			Assert.assertFalse(true,"Framework supports on chrome and firefox browsers.");
		}
		
		//Maximize and delete all cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	/**
	 * This method helps to choose environment, such as QA,DEV.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return It does not return anything
	 * @throws Exception -> Exception caller to handle the exception
	 */
	public static void setEnv() throws Exception {

		String environment = PropertyHelper.getProperty("environment");
		if (environment.equalsIgnoreCase("qa")) {
			baseUrl = PropertyHelper.getProperty("qaURL");
		} else if (environment.equals("dev")) {
			baseUrl = PropertyHelper.getProperty("devURL");
		} else {
			Assert.assertFalse(true, "Enter correct Environment!!!");
		}

	}

	/**
	 * This method sets the driver with type.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return It does not return anything
	 * @throws Exception -> Exception caller to handle the exception
	 */
	public static void setDriver() throws Exception {
		setBrowserDriver();
	}

	/**
	 * This method get the driver.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return driver -> It returns webdriver
	 * @throws Exception -> Exception caller to handle the exception
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * This method sets the environment.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return It does not return anything
	 * @throws Exception -> Exception caller to handle the exception
	 */
	public static void setEnvironment() throws Exception {
		setEnv();
	}

	/**
	 * This method get the environment where wanted to run under the test.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return baseUrl -> URL where application under test
	 */
	public static String getEnvironment() {
		return baseUrl;
	}

	/**
	 * This method wait for the 5 secs.
	 * @author Nisha Vekariya
	 * @author https://github.com/NisVek-Automation
	 * @return It does not return anything
	 */
	public static void waitForPageToLoad() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
