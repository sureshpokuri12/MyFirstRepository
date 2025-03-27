@regression
Feature: New Customer Creation

  Background: 
    Given User open the URL in the browser
    And User enters the username in the username field as "mngr617856"
    And user enters the password in the password field as "abypAhE"
    When user clicks the login button in the appliaction
    Then user will navigated to Guru99 demo application homepage

  Scenario Outline: Creating new customer with all details
    And User clicks on New Customer creation link in the demo guru99 app
    And User enters Customer name "<customername>"
    And User selects the gender
    And User enters Date of Birth "<dateofBirth>"
    And User enters Address "<address>"
    And User enters city "<city>"
    And User enters state "<state>"
    And User enters pin "<pin>"
    And User enters Mobile Number "<mobilenumber>"
    And User enters Email "Dynamic"
    And User enters Password "<password>"
    Then User submits the form
    And User captures the Customer ID
    #And user completes the execution
    And user complete the execution

    Examples: 
      | customername | dateofBirth | address  | city | state    | pin    | mobilenumber | password |
      | John Doe     | 01-01-1990  | Street 1 | NYC  | New York | 100011 |   9876543210 | John@123 |
    #Examples: 
      #| customername | dateofBirth | address  | city | state     | pin     | mobilenumber | email          | password  |
      #| John Doe    | 01-01-1990  | Street 1 | NYC  | New York  | 100011  | 9876543210   | john@gmail.com | John@123  |
      #| Alice       | 15-05-1985  | Street 2 | LA   | California| 900012  | 8765432109   | alice@gmail.com| Alice@456 |
