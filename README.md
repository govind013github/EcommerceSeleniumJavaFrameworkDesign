# Ecommerce Selenium Java Framework Design

This repository contains automated tests for an Ecommerce website using the Selenium WebDriver, Java programming language, Page Object Model (POM) design pattern, and TestNG testing framework.

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
- [Usage](#usage)
- [Page Object Model](#page-object-model)
- [TestNG Framework](#testng-framework)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project aims to demonstrate the automation of Ecommerce website testing using Selenium WebDriver with Java, following the Page Object Model design pattern and utilizing the TestNG testing framework. The Page Object Model design pattern helps in maintaining a clear separation between test code and page-specific code, making the tests more maintainable and reducing code duplication.

## Setup

1. Clone the repository:

```bash
git clone https://github.com/govind013github/EcommerceSeleniumJavaFrameworkDesign.git
```

2. Install Java Development Kit (JDK) version 11 if not already installed.
3. Install Maven (if not already installed) for managing project dependencies.
4. Download and set up the WebDriver (Chrome, Firefox, etc.) compatible with your browser version.

## Usage

1. Navigate to the project directory:

```bash
cd EcommerceSeleniumJavaFrameworkDesign
```

2. Build the project:

```bash
mvn clean install
```

3. Run the tests:

```bash
mvn test
```

## Page Object Model

The Page Object Model (POM) design pattern is employed to organize and structure the automation framework. Each page of the Ecommerce website has a corresponding Page Object class, encapsulating the page's elements and interactions. This separation allows for easy maintenance and enhances test readability.

```
src/
└── main/
│   └── java/
│       ├── pages/
│       │   ├── HomePage.java
│       │   ├── ProductPage.java
│       │   ├── CartPage.java
│       │   └── ...
│       └── utils/
│           ├── DriverManager.java
│           └── ...
└── test/
    └── java/
        ├── tests/
        │   ├── AddToCartTest.java
        │   ├── CheckoutTest.java
        │   └── ...
        └── utils/
            ├── TestBase.java
            └── ...
```

## TestNG Framework

TestNG is used for test orchestration and execution. TestNG provides various features such as grouping, parallel execution, and reporting. TestNG configuration allows customization of test execution behavior, such as defining test suites and setting up test dependencies.

## Contributing

Contributions to this project are welcome! If you find any issues or want to add new features, feel free to open a pull request. Please ensure that your code follows the established coding standards and includes appropriate tests.

Feel free to customize this README to match the specifics of your project. Make sure to update placeholders (such as repository URL, file paths, etc.) with your actual project details.

----------------------------------------------------------------------------------------------------------------------------

Following Below Steps are Implemented in Designing the Selenium-Java Ecommerce Application Framework from Scratch.

1. Creating the Maven Structure:
   - Created a structured Maven framework with all the necessary automation dependencies, including Selenium, Java, TestNG, and Maven. This was done using Eclipse as the IDE.

2. Choosing the Ecommerce Application:
   - Selected a practice ecommerce application to automate the end-to-end flow, covering all the mentioned test scenarios.

3. Implementing Page Object Model:
   - Implemented the page object model mechanism to centralize and manage locators from respective classes.

4. Encapsulation of Object Creation:
   - Encapsulated object creation within page object classes, enhancing modularity and separation of concerns.

5. Creating Base Test Class:
   - Developed a base test class responsible for browser configuration details and global properties setup.

6. Test Strategy Implementation:
   - Devised a test strategy involving appropriate annotations for test grouping and distribution.

7. TestNG Runner Configuration:
   - Set up a TestNG runner file to facilitate test execution control from a single entry point.

8. Test Categorization with Groupings:
   - Utilized sample groupings in the TestNG XML file to categorize tests for distinct execution scenarios.

9. Data-Driven Testing and Parameterization:
   - Implemented data-driven testing and parameterization using TestNG DataProviders, HashMaps, and JSON file readers. Also integrated TestNG listeners to capture automatic screenshots on test failures and logging.

10. TestNG Retry Mechanism:
    - Incorporated a TestNG retry mechanism to automatically rerun failed tests, addressing flaky test scenarios in the practice ecommerce application.

11. Generating Comprehensive Reports:
    - Created and implemented an Extent Report wrapper to generate detailed HTML reports for the application. Made framework enhancements to support parallel execution using a thread-safe mechanism.

12. Maven Integration and Project Dependencies:
    - Integrated the TestNG Maven plugin to facilitate running framework tests using Maven commands. Refer to the POM.xml file for more details regarding project dependency setup.

By following these steps, I have established a robust and modular Selenium-Java ecommerce application framework, enabling efficient test automation and comprehensive reporting. This framework ensures streamlined test execution and management, contributing to effective software quality assurance practices.



