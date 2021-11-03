# Selenium BDD Framework
![Selenium BDD Framework](https://github.com/NisVek-Automation/NisVek-Automation/blob/main/readmeResources/SeleniumBDD.gif)

Don't forget to give this project a ⭐
<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

## 📝 Table of Contents

- [About](#about)
- [Technologies](#technologies)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Getting Started](#getting_started)
- [Framework Structure](#framework-structure)
- [Logs and Reporting](#logs-reporting)
- [Contributing](#contributing)
- [Authors](#author)

## 🕹 About <a name = "about"></a>
This Repository provides the basic testing framework to start the automation testing.

---

## 🖥️ Technologies <a name = "technologies"></a>

- [Selenium](https://www.selenium.dev/)
- [Java](https://www.java.com/en/)
- [TestNG](https://testng.org/doc/)
- [Cucumber](https://cucumber.io/)
- [Maven](https://maven.apache.org/)
- [log4j](https://logging.apache.org/log4j/2.x/)
- Page Object Model

---

## ⚙️ Installation <a name = "installation"></a>

#### 🎯 Prerequisite:

- [Java](https://www.java.com/en/download/help/index_installing.html) - Programming language
- [Eclipse](https://www.eclipse.org/downloads/) - Editor
- [Maven](https://maven.apache.org/index.html) - Software project Management tool

#### 🔌 Plugins:

- [TestNG for Eclipse Plugin](https://testng.org/doc/eclipse.html)
- [Maven Integration for Eclipse](https://marketplace.eclipse.org/content/maven-integration-eclipse-luna-and-newer)
- [Cucumber Eclipse Plugin](http://cucumber.github.io/cucumber-eclipse/)
- Natural

All set!!! Just download the Project folder...

---

## 🔁 Dependencies <a name = "dependencies"></a>

Automation framework dependancies are mentioned in the <b>POM.xml</b> file, and are not limited to.

---
## 👩‍💻 Getting Started <a name = "getting_started"></a>

How to use this framework?
- Clone the repository to your workspace.

```sh
git clone https://github.com/NisVek-Automation/Selenium-Java-TestNG-BDD.git
```

- Run the TestNG.xml file. You can even run as mvn test which will trigger the TestNG.xml

---

## 🏗️ Framework Structure <a name = "framework-structure"></a>

src/com/nisha

	base --> contains Base class for driver factory
	
	features --> Cucumber/Gherkin feature files directory
	
	hooks --> Hooks class file
	
	pageObject --> Page object model for each application page which contains object locators and functionality of respective page
	
	resource --> Resources which required for project and framework configurations
	
		config.properties --> Project related configuration settings
	
		extent-config.xml --> Controls the reporting structures of extent log report
		
		extent.properties --> Controls all reporting log files
	
		log4j.properties --> Controls all logging to console and log files
	
	runner --> Test runner file (@CucumberOptions parameters)
	
	stepDefinations --> Step Definition files
	
	utility --> Utilities developed in the framework which are easily use in framework
	
	      CommonFunctions --> Methods which easily used for selenium UI operations such as click, enter values and verify
	      
	      ConstantHelper --> Constant values which are used in framework
	      
	      ExcelSheetHelper --> Excelsheet related functions
	      
	      ExceptionHelper --> Custome exception for the framework
	      
	      PropertyHelper --> Represents the read functionality of property file

logs --> Execution logs is generated here by log4j2

target --> HTML report gets generated

	extent report --> inside ExtentReport folder
	
	cucumber report --> inside cucumberReports folder
	
pom.xml --> Maven pom file for build and dependencies

testng.xml --> TestNG configuration file

---

## 💬 Contributing <a name = "contributing"></a>

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

---

## ✍️ Author <a name = "author"></a>

- [@NisVek-Automation](https://www.linkedin.com/in/nisha-vekariya/) - Nisha Vekariya
