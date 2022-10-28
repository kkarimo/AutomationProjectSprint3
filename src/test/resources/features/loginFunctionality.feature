@AGLP-1522
Feature: Login Functionality
  Agile story: As a user, I should be able to login

  @smoke
  Scenario Outline: User logins as HR user with Valid Credentials
    When user navigates to login page
    When user enters username "<username>"
    When user enters password "<password>"
    Then user clicks login button
    Examples:
      | username               | password |
      | hr1@cybertekschool.com | UserUser |
      | hr2@cybertekschool.com | UserUser |

  @AGLP-1532
  Scenario Outline: User logins as Helpdesk user with Valid Credentials
    When user navigates to login page
    When user enters username "<username>"
    When user enters password "<password>"
    Then user clicks login button
    Examples:
      | username                     | password |
      | helpdesk1@cybertekschool.com | UserUser |
      | helpdesk2@cybertekschool.com | UserUser |

  @AGLP-1533
  Scenario Outline: User logins as Marketing user with Valid Credentials
    When user navigates to login page
    When user enters username "<username>"
    When user enters password "<password>"
    Then user clicks login button
    Examples:
      | username                      | password |
      | marketing1@cybertekschool.com | UserUser |
      | marketing2@cybertekschool.com | UserUser |

    @AGLP-1534
  Scenario Outline: User does not login with invalid credentials
    When user navigates to login page
    When user enters invalid username "<username>"
    When user enters invalid password "<password>"
    Then user clicks login button
    Examples:
      | username                      | password |
      | marketing1@invalid.com        | UserUser |
      | marketing2@cybertekschool.com | invalid  |

  @AGLP-1544
  Scenario Outline: User is not allowed to try logging in after 5 attempts with invalid credentials.
  (Error message should be "Please try again after one minute")
    When user navigates to login page
    When user repeats entering invalid "<username>" and "<password>" credentials five times
    Then user gets "<error message>"
    Examples:
      | username            | password | error message                     |
      | invalid@invalid.com | invalid  | Please try again after one minute |