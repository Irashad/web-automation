# About this project

1. To run the test in different browsers execute this in command line:
`./runTests.sh browser=firefox` or `./runTests.sh browser=chrome`
you can also just run `'./runTests.sh'` it will run chrome by default if you don't pass any argument.
currently for demo purpose Chrome and Firefox available
2. Test type is E2E
3. All test task succeed
4. Selecting by Select class for the given Jobs Page doesn't working in Firefox - need more investigation - hence used different approach to support both firefox chrome
3. Screenshot taken within onTestFailure() method (Currently unable to make this screenshot embed to TestNG report - needs further investigation. or we could use Allure,ExtentReport or cucumber report whenever there is enough time). Instead it will add the screenshot to project directory)

## Current Workflow
when we call `./runTests.sh browser=firefox` from terminal it will execute ./runtests.sh with browser parameter.
this will call the gradle task which is registered as 'EndToEnd'. Then EndToEnd task will execute the E2E.xml with TestNG. -> E2E.xml will execute the test in JobSearch.

## What improvements we can do?
1. We can define general one way to approach elements either with xpath or css selector for consistency
2. We can widen our framework by adding Docker together with Jenkins and using EC2 isntances as nodes.
3. We can define Exception library and use it as per our needs.
4. We can also use "Harmcest.Matchers" library for better assertion experience
5. We should definitely widen gradle tasks. e.g SmokeTest,FullRegression etc. in order to execute this tasks either for daily health checks or full regression before release
6. We can use TeamCity to trigger jobs as per  schedule
7. EC2 instances to divide nodes. This will be very helpful when there is parallel execution of tests as well as to schedule jobs on different nodes
8. Docker for managing test environment,its speed because containers are lightweight,  with Docker container its way much easier to maintain the tests in any environment and + Isolation
9. BrowserStack to execute web tests in different mobile devices 
10. Cucumber to make scenarios more readable, reusable steps, It is well going with CucumberReport+TeamCity
11. We can widen the Utils library and make its Jar file  and then add it to our project as external tool.
12. Would be better if we  implement sonarcloud to our project  as it helps developers, automation engineers to understand the code smells, Security issues and fix them 
13. Creating tags and fixing test code bugs for our test project in every release - so we will have stable runs.
14. We can separate the components from page objects so we can reuse them in between many page objects. Example Top Navigation bar in useinsider.com
15. We can add test groups to group the tests in testng.xml (in our case its E2E.xml) - it will help us to group the same type of tests. e.g smoke tests.
16. We could have DB connection utils in order to execute SQL queries to verify tests on Database end