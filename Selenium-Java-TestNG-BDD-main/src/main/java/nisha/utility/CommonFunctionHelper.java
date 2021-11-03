package nisha.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import nisha.base.DriverFactory;

/** 
 * Represents a common function helper to read the Testing data.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation 
 * @version 1.0
*/
public class CommonFunctionHelper {
	
	/** This is a WebDriver instance to handle all selenium functions. */
	  private WebDriver commonFunctiondriver;
	  /** This is a WebDrvier Wait Instance Variable. */
	  private WebDriverWait wait;
	  
	  /**
	   * This Constructor initializes the WaitFactory for the
	   * CommonFunctionWebElement Class.
	   * @author https://github.com/NisVek-Automation 
	   * @author Nisha Vekariy
	   * @param driver -> Webdriver object
	   */
	  public CommonFunctionHelper(WebDriver driver) {
		  this.commonFunctiondriver = driver;
		  //Initiate the WebDriverWait object
		  this.wait = new WebDriverWait(commonFunctiondriver, ConstantHelper.waitTime);
	  }
	  
	  /**
	   * This method verify the the current URL contains the searched element.
	   * @author Nisha Vekariya
	   * @param expectedURL -> expected URL to compare with
	   * @throws Exception -> Exception caller to handle the exception
	   * @return flag -> Returns true if expected and current URL is same else false
	   */
	  public boolean isUrlContains(final String searchElement) throws Exception {
	    String currentURL = null;
	    String replacedSearchElement = searchElement.replace(" ", "+");
	    boolean flag = false;
	    try {
	      currentURL = commonFunctiondriver.getCurrentUrl();
	      flag = currentURL.contains(replacedSearchElement);
	    } catch (Exception e) {
	    	Reporter.log(e.getMessage());
	      throw new Exception(e);
	    } 
	    return flag;
	  }
	  
	  /**
	   * This method clicks on the given element if it is visible,enabled and
	   * clickable.
	   * @author https://github.com/NisVek-Automation
	   * @author Nisha Vekariya
	   * @param objectTobeClicked -> WebElement that needs to be clicked
	   * @throws ExceptionHelper -> Custom exception object for ExceptionHelper caller
	   *           to handle the exception
	   * @throws Exception
	   *           -> Exception caller to handle the exception
	   */
	  public void clickElement(final WebElement objectTobeClicked) throws ExceptionHelper, Exception {
	    try {
	      if (isElementClickable(objectTobeClicked) == true) {
	    	  objectTobeClicked.click();
	      } else {
	        throw new ExceptionHelper("Unable to wait for element and also it is not clickable.");
	      }
	    } catch (ExceptionHelper e) {
	    	Reporter.log("Unable to wait for element and also it is not clickable.");
	    	Reporter.log(e.getMessage());
	      throw new ExceptionHelper(e);
	    } catch (Exception e) {
	    	Reporter.log("Unable to click on the element");
	    	Reporter.log(e.getMessage());
	      throw new Exception(e);
	    }
	  }
	  
	  /**
	   * This method enter value on the given element if it is visible,enabled and
	   * clickable.
	   * @author https://github.com/NisVek-Automation
	   * @author Nisha Vekariya
	   * @param objectTobeClicked -> Webelement that needs to be clicked
	   * @throws ExceptionHelper -> Custom exception object for ExceptionHelper caller
	   *           to handle the exception
	   * @throws Exception
	   *           -> Exception caller to handle the exception
	   */
	  public void enterText(final WebElement element, String textToEnter) throws ExceptionHelper, Exception {
	    try {
	      if (isElementClickable(element) == true) {
	    	  element.sendKeys(textToEnter);
	      } else {
	        throw new ExceptionHelper("Unable to wait for the element tobe clickable.");
	      }
	    } catch (ExceptionHelper e) {
	    	Reporter.log("Unable to wait for the element tobe clickable.");
	    	Reporter.log(e.getMessage());
	      throw new ExceptionHelper(e);
	    } catch (Exception e) {
	    	Reporter.log("Unable to wait for the element tobe clickable.");
	    	Reporter.log(e.getMessage());
	      throw new Exception(e);
	    }
	  }
	  
	  
	  /**
	   * This method clear the text in the textBox element specified.
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @param element
	   *          -> WebElement in which the text should be entered
	   * @throws ExceptionHelper
	   *           ->Custom exception object for ExceptionHelper caller to handle the exception
	   * @throws Exception
	   *           -> Exception caller to handle the exception
	   * @return flag
	   *           -> True if text is cleared, else false 
	   */
	  public boolean clearText(final WebElement element) throws ExceptionHelper, Exception {
	    String elementText;
	    boolean flag = false;
	    try {
	      if (isElementClickable(element) == true) {
	    	  element.clear();
	        elementText = element.getAttribute("value");
	        if(elementText.isEmpty()){
	          flag = true;
	        } 
	      } else {
	        throw new ExceptionHelper("Unable to wait for the element tobe clickable in clearText.");
	      }
	    } catch (ExceptionHelper e) {
	    	Reporter.log("Unable to wait for the element tobe clickable in clearText.");
	    	Reporter.log(e.getMessage());
	      throw new ExceptionHelper(e);
	    } catch (Exception e) {
	    	Reporter.log("Unable to clear the text");
	    	Reporter.log(e.getMessage());
	      throw new Exception(e);
	    } 
	    return flag;
	  }
	  
	  /**
	     * This method waits until the element is visible and known to be present on the DOM.
	     * @author https://github.com/NisVek-Automation
	     * @author Nisha Vekariya
	     * @param locator ->locator Element
	     * @return true -> when element it is visible
	     * @throws Exception -> caller to handle the exception
	     */
	    public boolean isElementVisibile( final WebElement locator) throws Exception {
	        WebElement element = null;
	        boolean flag = false;
	        try {
	            element = wait.until(ExpectedConditions.visibilityOf(locator));
	            flag = isElementNull(element);
	        } catch (final Exception e) {
	        	Reporter.log("unable to wait for visibility of the element");
	        	Reporter.log(e.getMessage());
	            throw new Exception(e);
	        }
	        return flag;
	    }
	    
	    /**
	     * This method waits until the element is clickable on the DOM of the page.
	     * @author https://github.com/NisVek-Automation
	     * @author Nisha
	     * @param locator
	     *            -> Web locator Object
	     * @return true -> Once it is located, otherwise false
	     * @throws Exception
	     *             Caller to handle exception
	     */
	    public boolean isElementClickable(final WebElement locator) throws Exception {
	        WebElement element = null;
	        boolean flag = false;
	        try {
	            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	            flag = isElementNull(element);
	        } catch (final Exception e) {
	        	Reporter.log("Unable to wait for the clickable of the element in DOM");
	        	Reporter.log(e.getMessage());
	            throw new Exception(e);
	        } 
	        return flag;
	    }
	    
	    public boolean isElementNull(final WebElement element){
	    	if(element != null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    
	    /**
	     * This method launch the application.
	     * @author https://github.com/NisVek-Automation
	     * @author Nisha
	     * @param url
	     *            -> URL to be launch
	     */
	    public void launch_URL(String url) {
			DriverFactory.waitForPageToLoad();
			commonFunctiondriver.get(url);
			wait.until(ExpectedConditions.urlToBe(url));
			//System.out.println("+++++++++++++++++ commonFunctiondriver.getCurrentUrl() : " + commonFunctiondriver.getCurrentUrl());
			Assert.assertEquals(url, commonFunctiondriver.getCurrentUrl());
			
		}

	    /**
	     * This method refresh the application.
	     * @author https://github.com/NisVek-Automation
	     * @author Nisha
	     */
		public void refresh_Page() {
			commonFunctiondriver.navigate().refresh();
		}
}

