package nisha.stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import java.util.*;

import io.cucumber.datatable.DataTable;
import nisha.base.DriverFactory;
import nisha.pageObject.LoginPage;
import nisha.pageObject.ProductPage;
import nisha.utility.CommonFunctionHelper;


/** 
 * Represents DataDriven functionality using example.
 * This class collects login credentials from the feature file and
 * perform the datadriven testing.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class DatadrivenExample {
	
	public WebDriver driver;
	public CommonFunctionHelper commonFunctions;
	public LoginPage login;
	public ProductPage proPage;
	private String url;
	
	@Before
    public void beforeScenario() throws Exception {
		driver = DriverFactory.getDriver();
		commonFunctions = new CommonFunctionHelper(driver);
		login = new LoginPage(driver);
		proPage = new ProductPage(driver);
    }
	
	@Given("Open Browser and enter url")
	public void open_Browser_and_enter_url() {
		
		url = DriverFactory.getEnvironment();
		commonFunctions.launch_URL(url);
		
	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String userName, String userPsw) {
		//Enter username and password
		login.enterUserName(userName);
		login.enterUserPassword(userPsw);
	    System.out.println("UserName : " + userName + " and User Password : " + userPsw);
	}

	@Then("After submit, Home page should be opened")
	public void after_submit_Home_page_should_be_opened() {
		//login and check home page
		login.clickLoginButton();
		proPage.verifyHomePageLogo();
	}
	
	
	@After("@Signup-DataDriven-Test")
    public void afterScenario(){
		//Logout from page
		proPage.logoutFromApp();
    }

	//--------------------Scenario : Exmple with data table ---------------------------
	
	@Then("I enter email address of new user as {string}")
	public void i_enter_email_address_of_new_user_as(String CustEmail) {
		System.out.println(" Entered the new email of customer : " + CustEmail);
	}

	@Then("I enter my personal informations")
	public void i_enter_my_personal_informations(DataTable dataTable) {
	    List<Map<String, String>> listMapRows = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> mapColumns : listMapRows) {
	    	System.out.print("\n Customer FirstName : " + mapColumns.get("customerFirstName") +" , Customer LastName : " + mapColumns.get("customerLastName") + " , and title : " + mapColumns.get("title"));
	  
	    }
	}

	@Then("I enter my address informations")
	public void i_enter_my_address_informations(io.cucumber.datatable.DataTable dataTable) {
	   
		 System.out.print("\n=======Verify data using  List<Map<K,V>> ===========");
		    List<Map<String, String>> listMapRows = dataTable.asMaps(String.class, String.class);
		    for (Map<String, String> mapColumns : listMapRows) {
		    	System.out.print("\n FirstName : " + mapColumns.get("firstName") +" , LastName : " + mapColumns.get("lastName") + " , and Company : " + mapColumns.get("company"));
		  
		    }
	}
}
