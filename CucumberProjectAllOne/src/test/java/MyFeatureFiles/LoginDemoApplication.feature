@sanity
Feature: Login for Guru99 demo application

  Scenario Outline: To validate Login Guru99 Demo application with valid username and password
    Given User open the URL in the browser
    And User enters the username in the username field as "<username>"
    And user enters the password in the password field as "<password>"
    When user clicks the login button in the appliaction
    Then user will navigated to Guru99 demo application homepage
    And user complete the execution

    Examples: 
      | username   | password |
      | mngr617856 | abypAhE  |
