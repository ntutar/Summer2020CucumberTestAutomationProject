Feature: As user I want to be able to login under different roles

  Scenario: Login as a sales manager
    Given user on the landing page
    When user logs in
    Then user should see dashboard page