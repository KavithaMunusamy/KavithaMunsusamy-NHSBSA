# NHS COST ELIGIBILITY CHECKER

**Project Title:**
Automation of NHS Cost Checker Tool

**Design:**
1. Framework : BDD Framework test driven by test scenarios using cucumber 6, selenium 4 and Java 1.8
2. Report and Logging: Allure reports are used to capture the failure test cases with screenshot. Logging are performed using log4j capturing debug and info level logs for debugging purpose.
3. Utility: Utility Modules contains resuable files like Properties files configuration, json parser for test data, Wait methods and other common functionalities.
4. Test scripts : Test steps and action are scripted based on feature and sceanrios.  Pages are defined using Page Object Model with page factory approach.
5. Build Tool: Maven is used to build the project using POM.xml and also add the project dependencies.
6. Version Control System: The project is maintained in GitHub for versioning and updating the future changes.

**Features of the Project:**
1.	Project is developed for the website:https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start
2.	Automated the following Scenarios:
i.	Living Country Selection
ii.Eligibility check for UK citizen living in england and has diabetic condition.
  a.examples can be added in test json file for eligibility options
  b.Actions are available for each eligibility check which can be reused to automate different eligibility check.

3.	Handled both Positive and Negative test scenarios.
4.	The configurations like base URI, browser are included in config.properties.
5.	Adhered to best practices of Java and selenium automation.

The test can be run using the command: mvn clean test
