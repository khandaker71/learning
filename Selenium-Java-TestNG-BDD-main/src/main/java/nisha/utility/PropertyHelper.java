package nisha.utility;

import java.util.*;  
import java.io.*; 

/** 
 * Represents a property reading helper to read the property file data.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation 
 * @version 1.0
*/
public class PropertyHelper {
	
	private static FileReader reader;
	private static Properties property;
	
	/**
	   * This method basic initialization of property file. 
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation 
	   * @return It does not return anything.
	*/
	public static void initProperty(){
		
		try {
			reader=new FileReader(ConstantHelper.propertyFilePath);
			property=new Properties();  
			property.load(reader);
		} catch (FileNotFoundException e) {
			System.out.println("Property file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Property file not loaded.");
		}  
	}
	
	/**
	   * This method provide property value. 
	   * @author Nisha Vekariya
	   * @author https://github.com/NisVek-Automation
	   * @param proName -> represents the property name
	   * @return returns property value based on passed property name.
	*/
	public static String getProperty(String proName){
		return property.getProperty(proName);
	}
}
