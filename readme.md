![](https://img.shields.io/badge/Selenium-Java-darkgreen?style=flat-square&logo=selenium)
![](https://img.shields.io/badge/Build_Automation-Maven-red?style=flat-square&logo=apachemaven&logoColor=red)
![](https://img.shields.io/badge/DesignPattern-Page_Object_Model-aqua?style=flat-square&logo=page)
![](https://img.shields.io/badge/Docker-gray?style=flat-square&logo=docker)
![](https://img.shields.io/badge/Selenium_Grid-gray?style=flat-square&logo=selenium)

## Table of contents
* [Overview](#overview)
  * [Why Page Object Model (POM)](#why-page-object-model-(POM)?)
  * [Page Navigation](#page-navigation)
  * [Configuration](#configuration)
* [Tests](#tests:)
  * [Run Tests in local](#run-tests-in-local)
  * [Run Tests in Grid](#run-tests-in-grid)
  * [Run the entire framework as docker using selenium grid](#run-the-entire-framework-as-docker-using-selenium-grid)
****


# Overview
This is Selenium java framework using page object model design pattern and maven. 
Some key features of framework includes:
    
  - Customized wrapper classes
  - Inbuilt logger and extent report
  - Configuration
  - Custom Controls: used to have own controls and write our own custom methods which selenium does not provide out of box.
  - Base Abstract class rather than page initializing in every class, this makes code much simpler and easy to understand.

This framework offers:
- Reusability
- Scalability
- Maintainability
- Understandability
- Workability
- As generic as possible (close to reusable for any application)
- Extendable (Should support web service testing, UI testing)
- Wrappable – does not depend on any of selenium version, we have our own controls

## Why Page Object Model (POM)?
- Reduce number of duplicate code
- Maintain object in separate class file
- Improve readability of code
- Handle each page using its instance
- Establish relation between each page

## Page Navigation
Using page navigation we can establish relationship between each page, so that anytime while operation is performed on one method, it may or may not return page object
This will ensure the business logic embedded in our test code and wont loose behaviour of application.

## Configuration:
Current configuration file supports below fields
- Application URL
- Browser
- TestType
- Technology
- Log path

# Tests:
Sample amazon test is written. To execute test you have below options:
- Run test in local
- Run tests in Selenium Grid
  - Run the entire framework as docker 
    - Use selenium grid
    - Use standalone chrome driver

## Run Tests in local
- Update ExecutionEnv as `local` in GlobalConfig.properties file which is located under below directory:
src -> test -> java
- Optionally you can update report path and or framework path in config file
- Execute amazonTests.xml file located under src->test->java->core->framework->runner
- or you can directly execute testNG test located under src->test->java->core->framework->tests->amazonTest->shoppingTest method

## Run Tests in Grid
- Update **ExecutionEnv** as `remote` in GlobalConfig.properties file which is located under below directory:
  src -> test -> java
- update **RemoteDriverUrl** to your grid url in GlobalConfig.properties file which is located under below directory:
  src -> test -> java
- Optionally you can update report path and or framework path in config file
- Execute amazonTests.xml file located under src->test->java->core->framework->runner
- or you can directly execute testNG test located under src->test->java->core->framework->tests->amazonTest->shoppingTest method

## Run the entire framework as docker using selenium grid
- Update **ExecutionEnv** as `docker` in GlobalConfig.properties file which is located under below directory:
  src -> test -> java
- You can provide **RemoteDriverUrl** while running the docker file
- Build the image with dockerfile using command ```docker build -t framework-selenium:latest .```
- Run the container with command as 
  ```docker run --name framework-selenium-container -e RemoteDriverUrl=http://192.168.1.7:4444 framework-selenium:latest ```
  Replace RemoteDriverUrl value to url where [grid is running](#how-to-run-selenium-grid) (** make sure to use IP address instead of localhost in url)



 selenium-java-framework\framework\src\test\java\core\framework\reports


docker run -e RemoteDriverUrl=http://192.168.1.7:4444 -v selenium:/app/src/test/java/core/framework/reports framework-selenium:latest