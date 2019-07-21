# Example Webdriver project

## Installation
1. download or clone source code.
2. import to IDE as Maven project.

## Test cases
you may find list of test cases [here](https://github.com/rlnir/automation/blob/master/tests.txt).

## Test Properties 
you may modify test properties in TestProps.properties file.
for example, you can choose browser by: browser=chrome or browser=firefox.

## BrowserStack integration
if you would like to run your test on your Browserstack account you need edit these properties in TestProps.properties file:
- isBrowserStack=true
- browserStack.User=[-your user-]
- browserStack.Key=[-your key-]

## Running Tests
1. find sanity.xml file in root.
2. run file as TestNG suite (usually right click on file -> run).

## Parallel Tests
test can run in parallel if adding following attributes TestNg xml file (by default it's like that):
```
thread-count="3" parallel="classes"
```

## Create Report
1. install Allure commandline application: [instructions](https://docs.qameta.io/allure/#_get_started).
2. make sure that you have run the tests at list once.
2. go to the root path of the project.
3. type and execute (in power shell or bash):
```
allure serve allure-results
```

a report should be generated and displayed in your browser.
