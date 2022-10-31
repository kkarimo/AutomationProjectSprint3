  @AGLP-1510
Feature: Logout Functionality
  Agile story: As a user, I should be able to logout

  Background: user is on the login page
    Given user is already logged in the app

    @AGLP-1579
  Scenario: Logout Functionality
    When user clicks the profile name
    When user clicks logout button
    Then user lands on login page
    #To verify that user lands on the login page,
    #this step asserts the actual page title with expected page title

  @AGLP-1580
  Scenario: User does not go to the home page after logging out
    When user clicks the profile name
    When user clicks logout button
    When user lands on login page
    Then user clicks back button

    @AGLP-1581
  Scenario: User does not stay logged in when closing and re-opening the tab(s)
    When user clicks the profile name
    When user clicks logout button
    When user closes the tab
    Then user navigates back to login page



