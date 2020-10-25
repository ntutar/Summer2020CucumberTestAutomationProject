package com.vytrack.ClassNotes;
/*
Today is October 25, 2020
Agenda:
  Review of: tags, parameters, background and hooks.
  New topic: cucumber data tables
###########################################
When user logs in as a "sales manager" -->  @When("user logs in as a {string}")
                                            public void user_logs_in_as_a(String string){
                                                string = "sales manager"
                                                loginPage.login(string);
                                            }
When user logs in as a "driver" -->        @When("user logs in as a {string}")
                                            public void user_logs_in_as_a(String string){
                                                string = "driver"
                                                loginPage.login(string);
                                            }
Then user should see 3 items           -->   @Then("user should see {int} items")
                                            public void user_should_see_items(Integer expected){
                                                expected = 3
                                                Integer actual = homePage.getNumberOfItems();
                                                Assert.assertEquals(expected, actual);
                                            }
Then user should see 15 items          -->   @Then("user should see {int} items")
                                            public void user_should_see_items(Integer expected){
                                                expected = 15
                                                Integer actual = homePage.getNumberOfItems();
                                                Assert.assertEquals(expected, actual);
                                            }
Then user should see 1550.99 balance   -->   @Then("user should see {double} balance")
                                            public void user_should_see_balance(Double balance){
                                                balance = 1550.99
                                                Double actualBalance = myAccountPage.getBalance();
                                                Assert.assertEquals(balance, actualBalance);
                                            }
1. Create feature file
2. Write scenario
3. Dry run
4. Implement undefined step definitions
2 common situations in the BDD automation.
1. You convert manual test cases into BDD scenarios.
2. Develop BDD scenarios based on acceptance criteria
Q: Where do you store your test cases?
- features folder.
Manual testers, usually store test cases in excel files and keep them in the shared drive. Since we are using Jira Xray we can say that manual test cases stored in Jira.
Xray - it's a test management plugin (add-on) for jira. Not every company that use Jira also use this plugin.
either we cerate separate feature file per page or per feature (user story).
1 scenario = 1 test case
TC - test case, general naming. Test Scenario - BDD test case.
git checkout src | revert all changes to the last commit in src folder
git pull         | to get latest code from github

 break until 3:12 EST
#TASK FOR 30 minutes
1. Under features folder create activities sub-folder
2. Create "CreateCalendarEvent.feature" file inside activities folder
3. Implement following scenario:
    @calendar_events
    Feature: As user, I want to be able to create calendar events
    Scenario: Create calendar event with default time
        Given user is on the login page
        And user logs in as a "store manager"
        And user navigates to "Activities" and "Calendar Events"
        And user clicks on create calendar event button
        When user adds new calendar event information
          | Title          | B20 Graduation Party                        |
          | Description    | All B20 friends are invited for this party! |
        And user clicks on save and close button
4. Add CreateCalendarEventPage.java class

    Create following web elements in this page class:
    - create calendar event button
    - title input box element
    - description input box element
5. Create void method clickOnCreateCalendarEvenBtn()
6. Create void method enterTitle(String value)
7. Create void method enterDescription(String value)
8. Perform dryRun
9. Implement undefined step definitions.
10. Create:

         CreateCalendarEventStepDefinitions.java class under step_definitions package
Check spelling first

 */
public class Notes_201025 {
}
