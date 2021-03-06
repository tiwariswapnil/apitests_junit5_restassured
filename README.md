# apitests_junit5_restassured

API Automation test for Pet Store APIs. 
Swagger Url of the API - https://petstore3.swagger.io/

### Technology Stack Used

* Build/Run Tool - Maven
* Test run framework - Junit 5
* API Client - Restasssured
* Clean Code and annotations - Lombok
* Binding for Lombok Slf4j logging - Slf4j Simple
* JSON Serialization/Deserialization - Jackson Databind

### Prerequisites to Run the project

Environment Requirements: Maven v3.5.4 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

### Tests Execution

* After cloning the project, compile using the IDE Maven plugin or `mvn clean compile`
* Tests can be run by any of following ways:
    * Command line using `mvn clean test` from project root directory
    * Run (green play) button in each Test class
    * Using IDE Run configuration, for IntelliJ:
        * Right click project and click Run as
        * Select Maven Build
        * Enter goals - clean test
        * Click Run

### Test Results

Results of Tests run can be viewed in any of the below:

* JUnit Test Run window in IntelliJ
* Maven console logs

## CircleCI Integration

GitHub project for the solution is integrated with CircleCI

* Configuration file is located [here][8]
* This configuration is to checkout the project, build, test and upload test results in CircleCI
* CircleCI Project: [pet-store-test][9]

[8]:.circleci/config.yml

[9]:https://app.circleci.com/pipelines/github/shilesh-r/pet-store-test
