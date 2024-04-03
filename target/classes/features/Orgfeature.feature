Feature: Login

  Scenario: login
    Given user navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When  user try to login with the exel file "src/test/java/fileProces/MOCK_DATA.xlsx"

