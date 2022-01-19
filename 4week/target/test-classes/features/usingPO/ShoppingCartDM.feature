Feature: testing shopping cart


  Scenario: Simple Scenario

    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page


    When  I navigate to Components and I click on Monitors
    Then I check amount of monitors


  Scenario: Sample Scenario
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page

    And I click Cameras
    And Check if top menu is displayed
    And I navigate to Components
    And I click on show all Components
    And Check if top menu is displayed
    And I navigate to Components
    And I click Monitors
    And Check if top menu is displayed



