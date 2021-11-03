package nisha.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import nisha.utility.CommonFunctionHelper;

/** 
 * Represents Product page - Page Object model.
 * This class contains all necessary WebElements and related functionality.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class ProductPage {

	WebDriver driver;
	CommonFunctionHelper commHelper;
	
	//---------- Objects-------------------
	@FindBy (className="app_logo") WebElement homePageLogo;
	@FindBy (xpath="//span[@class='title']") WebElement homePageTitle;
	@FindBy (className="shopping_cart_link") WebElement linkShoppingCart;
	@FindBy (id="add-to-cart-sauce-labs-backpack") WebElement btnAddToCartProductBackpack;
	@FindBy (id="react-burger-menu-btn") WebElement btnMenu;
	@FindBy (id="logout_sidebar_link") WebElement linkLogOut;
	
	//------------Methods------------------
	
	/**
	   * This constructer method set the driver and PageFactory
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @param driver -> WebDriver object
	   * @return It does not return anything.
	*/
	public ProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commHelper = new CommonFunctionHelper(driver);
	}
	
	/**
	   * This method verify the logo on product page
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @return It does not return anything.
	*/
	public void verifyHomePageLogo(){
		try{
			boolean flag;
			flag = commHelper.isElementVisibile(homePageLogo);
			Assert.assertEquals(flag, true, "Home Page logo is displayed.");
		}catch(Exception e){
			Reporter.log("Unable to Enter the UserName in Login page");
			Reporter.log(e.getMessage());
			Assert.assertFalse(true, "Unable to click Add to cart button for backpack in product page");
		}
	}
	
	/**
	   * This method click on AddToCart button on product page
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @return It does not return anything.
	*/
	public void clickOnAddToCart(){
		try{
			commHelper.clickElement(btnAddToCartProductBackpack);
		}catch(Exception e){
			Reporter.log("Unable to click Add to cart button for backpack in product page");
			Reporter.log(e.getMessage());
			Assert.assertFalse(true, "Unable to click Add to cart button for backpack in product page");
		}
	}
	
	/**
	   * This method click on shopping cart on product page
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @return It does not return anything.
	*/
	public void clickOnShoppingCart(){
		try{
			commHelper.clickElement(linkShoppingCart);
		}catch(Exception e){
			Reporter.log("Unable to click shopping cart link in product page");
			Reporter.log(e.getMessage());
			Assert.assertFalse(true, "Unable to click shopping cart link in product page");
		}
	}
	
	/**
	   * This method perform the logout operation on product page
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @return It does not return anything.
	*/
	public void logoutFromApp(){
		try{
			commHelper.clickElement(btnMenu);
			commHelper.clickElement(linkLogOut);
		}catch(Exception e){
			Reporter.log("Unable to logout from the page");
			Reporter.log(e.getMessage());
			Assert.assertFalse(true, "Unable to logout from the page");
		}
	}
	
	
}
