@Signup-DataDriven
Feature: This is DataTable demo testing
  This feature will check the dataTable demo of Cucumber

  Scenario: This is DataTable demo scenario
    Given Given the test data table for software engineers
    When verify the login values
      | name     | experience |
      | John     |          5 |
      | Lisa     |          8 |
      | Nisha    |         12 |
      | Vekariya |         15 |
    Then Data received succefully
