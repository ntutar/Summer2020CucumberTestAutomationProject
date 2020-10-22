package com.vytrack.ClassNotes;
/*
Today is October 21, 2020
Agenda:
    tags&parameters review
    hooks
    background
##########################
tags - to filter tests for the execution.
Q: How do you run specific tests/specific group of tests in your project?
A:
1. We are using tags to group test scenarios. We group them based on components, test suite
 For example: @smoke_test, @regression, @VYT_3433, @e2e
 Same tags can be placed on as many as you want scenarios.
2. We are pointing on the specific sub folder or features in the runner class:
    path to the all feature that we have: features = "src/test/resources/features",
    path to the specific feature: features = "src/test/resources/features/Login.feature",
    path to the sub-folder with features created for specific component:
    features = "src/test/resources/features/calendar",
    calendar - in this case, calendar folder stores all test scenarios related to the calendar component
    path to the multiples features:
    features =  {
                    "src/test/resources/features/Login.feature",
                    "src/test/resources/features/CreateCar.feature",
                    "src/test/resources/features/CreateCalendarEvent.feature",
                    "src/test/resources/features/EditCalendarEvent.feature",
                }
Q: How many test cases in your regression suite?
To count number of test cases in regression suite, we refer to the number of test scenarios.
I cannot tell you concrete number, but it can be from 100 - 2000 test scenarios.
Execution can take from 1 hour up to couple of days
Break until 8:10 EST
Hooks class - class that contains setup and tear down methods. These methods are running before and after every test scenario.
Q: How you can make sure that test scenarios will be executed only in specific browser/platform?
A: We can use tags to specify which browser can be used for the execution. Then, in the hook before we can read a tags and define specific browser for the execution.
Q: Background vs Hooks
 Before hook runs before every test scenario regardless on the scenario location (one before hook running for CreateCar.feature, Login.feature, CreateCalendarEvent.feature... scenarios).
After hook runs after every test scenario regardless on the scenario location (one after hook running for CreateCar.feature, Login.feature, CreateCalendarEvent.feature... scenarios).
Background common test steps (test precondition) within one particular feature file.

 */
public class Notes_201021 {
}
