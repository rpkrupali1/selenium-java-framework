This framework offers:

- Reusability
- Scalability
- Maintainability
- Understandability
- Workability
- As generic as possible (close to reusable for any application)
- Extendible (Should support web service testing, UI testing)
- Wrappable – does not depend on any of selenium version, we have our own controls

`"EVERYTHING SHOULD BE AS SIMPLE AS POSSIBLE, BUT NOT SIMPLER"`

- Albert Einstein

Page Object Model (POM)
- Reduce number of duplicate code
- Maintain object in separate class file
- Improve readability of code
- Handle each page using its instance
- Establish relation between each page

Created Base Abstract class rather than page initializing in every class, this makes code mich simpler and easy to understand.

Page Navigation
Using page navigation we can establish relationship between each page, so that anytime while operation is performed on one method, it may or may not return page object
This will ensure the business logic embedded in our test code and wont loose behaviour of application.

Generics:
Extra layer of abstraction

Configuration:
- Application URL
- Browser
- TestType
- -Technology
- Log path


Custom Controls:
Custom controls used to have own controls and write our own custom methods which selenium does not provide out of box.

Wait:
Explicit wait

MAVEN for:
- Build
- Deploy
- Test
- Report

Docker grid for Selenium
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:4.2.1-20220531
http://localhost:4444/ui
http://localhost:7900/
connect password - secret


---------------

docker build -t framework-selenium:latest .
docker run -it --name framework-selenium-container framework-selenium:latest /bin/bash
mvn clean test

