**BBLOG AUTOMATION TESTS**
---

##### General remarks
* Project usage: API + UI automation tests
* API tests are based on RestAssured framework
* UI tests are based on Selenium framework
* project uses Java 12 language
* project building tool - Maven
* project test manager framework - TestNG
* Lombok library is allowed

##### Project structure
Project is split into API and UI sections.

###### API section
* assertions - responsible for providing data based on assertable responses
* condition - responsible for providing data for response validations
* executors - responsible for fast data creation and providing data/preconditions for tests 
* resources - models based on API documentation
* services - provides connection configuration

###### UI section
todo

###### API test section
* test preconditions should be placed with @BeforeMethod annotation
* tests should be placed with @Test annotation
* multiple tests in one class are allowed
* possible clearing steps should be placed with @AfterMethod annotation
* for test run use command in terminal: mvn clean test

###### UI Test section
todo





