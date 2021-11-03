package nisha.utility;

import java.io.File;
import java.time.Duration;

/** 
 * Represents Project specific constant values.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class ConstantHelper {

	// Project root directory
	public static final String projectPath = System.getProperty("user.dir");
	public static final String screenShotPath = projectPath + File.separator + "screenShots" + File.separator;
	public static final String propertyFileName = "config.properties";
	public static final String propertyFilePath = projectPath + File.separator + "src/main/java/nisha/resource/" + propertyFileName;

	// DriverFactory URL
	public static final String url = "https://www.saucedemo.com/";
	

	// Wait timing
	public static final Duration waitTime = Duration.ofMillis(10000);
}
