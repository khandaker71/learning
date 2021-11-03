package nisha.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import nisha.base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Represents Hooks in framework.
 * 
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
 */
public class Hooks {

	WebDriver driver;

	@Before(order = 0)
	public void beforeScenarioStart() {
		System.out.println("-----------------Start of Scenario-----------------");
	}

	@Before(order = 1)
	public void setUp() throws Exception {
		// Setup the driver
		DriverFactory.setDriver();
		this.driver = DriverFactory.getDriver();
		DriverFactory.setEnvironment();

	}

	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		System.out.println("-----------------End of browser driver -----------------");
		if (scenario.isFailed()) {

			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png",
					"Step FAILED (Screenshot):");
		}
		// driver.close();
		driver.quit();
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("-----------------End of Scenario-----------------");
	}

}
