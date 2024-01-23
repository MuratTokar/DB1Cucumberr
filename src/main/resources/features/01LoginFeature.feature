Feature: Login

  Scenario: Login with user defined in yaml file

    Given user on homepage

    When user click SIGNUP on menu

    And user fills the login form as "user"

    And user clicks to button "Login"

    Then  login should be successful


