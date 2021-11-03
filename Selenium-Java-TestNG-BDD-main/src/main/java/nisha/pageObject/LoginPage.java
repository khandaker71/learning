package nisha.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import nisha.utility.CommonFunctionHelper;

/** 
 * Represents Login page - Page Object model.
 * This class contains all necessary WebElements and related functionality for the Login page.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class LoginPage {
	
	WebDriver driver;
	CommonFunctionHelper commHelper;
	
	//--------------- Objects--------------
	@FindBy (id="user-name") WebElement txtUserName;
	@FindBy(id="password") WebElement txtUserPsw;
	@FindBy(id="login-button") WebElement btnLogin;
	
	
	//----------------Methods--------------
	
	/**
	   * This constructer method set the driver and PageFactory
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param driver -> WebDriver object
	   * @return It does not return anything.
	*/
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commHelper = new CommonFunctionHelper(driver);
		
	}
	
	/**
	   * This method enters the userName
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param searchElement -> String which wanted to search from the Home page.
	   * @return It does not return anything.
	*/
	public void enterUserName(String userName){
		try{
			commHelper.enterText(txtUserName, userName);
		}catch(Exception e){
			Reporter.log("Unable to Enter the UserName in Login page");
			Reporter.log(e.getMessage());
		}
		
	}
	
	/**
	   * This method enters the login password
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param searchElement -> String which wanted to search from the Home page.
	   * @return It does not return anything.
	*/
	public void enterUserPassword(String userPsw){
		try{
			commHelper.enterText(txtUserPsw, userPsw);
		}catch(Exception e){
			Reporter.log("Unable to Enter the UserPassword in Login page");
			Reporter.log(e.getMessage());
		}
	}
	
	/**
	   * This method perform click operation on login button
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param searchElement -> String which wanted to search from the Home page.
	   * @return It does not return anything.
	*/
	public void clickLoginButton(){
		try{
			commHelper.clickElement(btnLogin);
		}catch(Exception e){
			Reporter.log("Unable to click login button in Login page");
			Reporter.log(e.getMessage());
		}
	}
	
	/**
	   * This method perform the login process
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param searchElement -> String which wanted to search from the Home page.
	   * @return It does not return anything.
	*/
	public void loginProcess(String userName, String userPsw){
		try{
			commHelper.clearText(txtUserName);
			commHelper.enterText(txtUserName, userName);
			commHelper.clearText(txtUserPsw);
			commHelper.enterText(txtUserPsw, userPsw);
			
			commHelper.clickElement(btnLogin);
			Assert.assertTrue(true, "Successfully click Login button in Login page");
			
		}catch(Exception e){
			Reporter.log("Unable to process the login in Login page");
			Reporter.log(e.getMessage());
			Assert.assertFalse(true, "Unable to process the login in Login page");
		}
	}
}
