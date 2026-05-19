Project Overview
This project automates the Contact Us form of the Safora website using Selenium WebDriver with Java and TestNG framework. It includes both a simple Selenium script and a TestNG based automation framework to demonstrate different levels of test automation approaches.

Technologies Used
•	Java 
•	Selenium WebDriver 
•	TestNG 
•	Maven 
•	Eclipse IDE 
•	ChromeDriver 

Project Structure
•	Simple Selenium Script (Non-TestNG) → Basic happy path automation 
•	TestNG Framework Script → Structured automation with multiple test cases (positive + negative scenarios) 

Project Setup (Maven + Eclipse)
This project is built using:
•	Java 
•	Selenium WebDriver 
•	TestNG 
•	Maven (dependency management) 
•	Eclipse IDE




 

Prerequisites
Ensure the following are installed before execution:
•	Java JDK 8 or higher 
•	Eclipse IDE 
•	Google Chrome (latest version) 
•	ChromeDriver (compatible with Chrome version) 
•	Maven configured in Eclipse 
•	TestNG plugin installed in Eclipse 

Maven Dependencies
Make sure your pom.xml includes:
•	Selenium Java 
•	TestNG 
(If already added, no extra configuration is required.)

How to Run the Tests
Option 1: Run from Eclipse (Recommended)
1.	Open Eclipse IDE 
2.	Navigate to:
SaforaContactUsTest.java
3.	Right-click inside the class file 
4.	Select:
Run As → TestNG Test
5.	Browser will launch and execute all test cases in priority order 






Option 2: Run Individual Test Cases
1.	Open the test class 
2.	Locate any method annotated with:
@Test
3.	Right-click on the specific test method 
4.	Select:
Run As → TestNG Test
5.	Only that test case will execute 
Execution Flow
When the script runs:
•	Chrome browser is launched 
•	Navigates to: https://safora.se/en/ 
•	Clicks on Contact Page 
•	Executes test scenarios including: 
	Positive form submission 
	Empty form validation 
	Invalid email test 
	Missing field validations 
	Boundary tests (name, phone) 
	CAPTCHA handling scenarios 

Expected Output
During execution, you will observe:
•	Console logs for each step 
•	Browser automation flow 
•	CAPTCHA handling (manual/automated attempt) 
•	Success or validation error messages 
•	TestNG results (Pass/Fail status) in Eclipse console 


Important Notes
•	CAPTCHA may require manual intervention depending on Google verification 
•	Additional delays (Thread.sleep) were added to handle reCAPTCHA loading and multiple verification challenges 
•	Some negative test cases may behave differently based on backend validation 
•	Ensure stable internet connection for page loading and CAPTCHA rendering 
•	Execution order is controlled using:
priority = 1, 2, 3...

Automation Approach
1. Simple Selenium Script (Non-TestNG)
A basic automation script used to demonstrate:
•	Basic Selenium WebDriver usage 
•	Single positive test scenario 
•	Simple execution flow without framework 

2. TestNG Framework Script
A structured automation framework used to demonstrate:
•	Professional test automation approach 
•	Use of TestNG annotations (@Test, @BeforeMethod, etc.) 
•	Execution of both positive and negative test cases 
•	Independent test execution per method 

 Framework Behavior Summary
•	No XML file is required for execution 
•	Tests are controlled using TestNG annotations 
•	Each test runs independently 
•	Browser is launched fresh for each test case 

Author: Ayesha Jayasinghe
