package nisha.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import nisha.utility.CommonFunctionHelper;

/** 
 * Represents Product page - YourCartPage.
 * This class contains all necessary WebElements and related functionality.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class YourCartPage {

	WebDriver driver;
	CommonFunctionHelper commHelper;
	
	//---------- Objects-------------------
	@FindBy (className="app_logo") WebElement homePageLogo;
	@FindBy (xpath="//span[@class='title']") WebElement homePageTitle;
	
	//------------Methods------------------
	
	/**
	   * This constructer method set the driver and PageFactory
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param driver -> WebDriver object
	   * @return It does not return anything.
	*/
	YourCartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commHelper = new CommonFunctionHelper(driver);
		
	}
	
	/**
	   * This method verify the logo
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @return It does not return anything.
	*/
	void verifyHomePageLogo(){
		try{
			boolean flag;
			flag = commHelper.isElementVisibile(homePageLogo);
			Assert.assertEquals(flag, true, "Home Page logo is displayed.");
		}catch(Exception e){
			Reporter.log("Unable to Enter the UserName in Login page");
			Reporter.log(e.getMessage());
		}
	}
}
