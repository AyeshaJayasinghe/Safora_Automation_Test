Safora Contact Us Automation Project

1.	Project Overview

This project automates the Contact Us form of the Safora website using Selenium WebDriver with Java and the TestNG framework.

The project demonstrates two different automation approaches:

Simple Selenium Script → Basic automation without framework support
TestNG Framework Script → Structured automation with multiple test scenarios

2.	Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Eclipse IDE
- ChromeDriver

3.	Project Structure

Safora-ContactUs-Automation
│
├── Simple Selenium Script (Non-TestNG)
│   └── Basic happy path automation
│
├── TestNG Framework Script
│   └── Multiple positive & negative test cases
│
└── pom.xml

4.	Project Setup (Maven + Eclipse)

This project is built using:

- Java
- Selenium WebDriver
- TestNG
- Maven (Dependency Management)
- Eclipse IDE

5.	Prerequisites

Ensure the following are installed before execution:

- Java JDK 8 or higher
- Eclipse IDE
- Google Chrome (latest version)
- ChromeDriver compatible with installed Chrome version
- Maven configured in Eclipse
- TestNG plugin installed in Eclipse

6.	Maven Dependencies

Ensure your `pom.xml` includes the following dependencies:

xml
<dependencies>

    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>

</dependencies>

7.	How to Run the Tests

Option 1: Run from Eclipse (Recommended)

1. Open Eclipse IDE
2. Navigate to:

SaforaContactUsTest.java

3. Right-click inside the class file
4. Select:

Run As → TestNG Test

5. Browser will launch and execute all test cases in priority order

Option 2: Run Individual Test Cases

1. Open the test class
2. Locate any method annotated with:

@Test

3. Right-click on the specific test method
4. Select:

Run As → TestNG Test

5. Only the selected test case will execute

8.	Execution Flow

When the script runs:

- Chrome browser launches
- Navigates to:
  - https://safora.se/en/
- Opens the Contact page
- Executes multiple test scenarios

9.	Included Test Scenarios

- Positive form submission
- Empty form validation
- Invalid email validation
- Missing field validations
- Boundary testing (Name & Phone fields)
- CAPTCHA handling scenarios

10.	Expected Output

During execution, you will observe:

- Console logs for each automation step
- Browser automation flow
- CAPTCHA handling (manual or automated attempt)
- Success and validation error messages
- TestNG Pass/Fail results in Eclipse console

11.	Important Notes

- CAPTCHA may require manual intervention depending on Google verification
- Additional `Thread.sleep()` delays are included to handle:
  - reCAPTCHA loading
  - Multiple verification challenges
- Some negative test cases may behave differently depending on backend validation
- Ensure a stable internet connection for:
  - Page loading
  - CAPTCHA rendering
- Test execution order is controlled using:
   -priority = 1, 2, 3...

12. Automation Approach

1. Simple Selenium Script (Non-TestNG)

A basic Selenium automation script used to demonstrate:

- Basic Selenium WebDriver usage
- Single positive test scenario
- Simple execution flow without framework support

 2. TestNG Framework Script

A structured automation framework used to demonstrate:

- Professional automation framework structure
- Usage of TestNG annotations:
  - `@Test`
  - `@BeforeMethod`
  - `@AfterMethod`
- Positive and negative test execution
- Independent execution for each test method

Framework Behavior Summary

- No XML configuration file is required
- Tests are managed using TestNG annotations
- Each test runs independently
- Browser launches fresh for every test case

Author: Ayesha Jayasinghe
