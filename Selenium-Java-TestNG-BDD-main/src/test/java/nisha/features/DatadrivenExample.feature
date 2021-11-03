@Signup-DataDriven
Feature: Login Functionality
	This feature will test a LogIn functionality

@Signup-DataDriven-Test
Scenario Outline: Verify the Login functionality for the different users
	Given Open Browser and enter url
    When User enters "<username>" and "<password>" 
    Then After submit, Home page should be opened
Examples:
    | username                | password |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |


Scenario Outline: Test successful registration of a new user
    Then I enter email address of new user as "<customerEmail>"
    Then I enter my personal informations
         | title   | customerFirstName | customerLastName |
         | <title> | <cFname>          | <cLname> |
    And I enter my address informations
         | firstName | lastName | company |
         | <fname> | <lname> | <company> |

     Examples:
        | customerEmail             | title                   | cFname | cLname   | fname | lname    | company |
        | nisha.vekariya@ibm.in.com | Sotware QA              | Nisha  | Vekariya | Nishi | Vekariya | IBM     |
    	| nisha.vekariya@cisco.com  | Sotware Automation Engg | Nisha  | Vekariya | Nishi | Vekariya | Cisco   |