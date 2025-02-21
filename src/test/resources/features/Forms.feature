@regression @forms
Feature: Forms
  Background:
    Given The user opens app web driver io
    When User click login navigation
    And User input email "user.saya@mail.com"
    And User input password "Saya123!"
    And User click button login
    Then Verify login success

  Scenario: @scenario1
    Given User click navigation forms
    When User input field forms scnario1
    And User verify that you have typed
    And User click button switch to ON
    And Verify switch text desc has ON
    And User select dropdown webdriver.io is awesome
    And User click button active
    Then Verify pop up this button active

  Scenario: @scenario2
    Given User click navigation forms
    When User input field forms scnario2
    And User verify that you have typed scnario2
    And User click button switch to OFF
    And Verify switch text desc has OFF
    And User select dropdown This app is awesome
    And User click button active
    Then Verify pop up this button active

  Scenario: @scenario3
    Given User click navigation forms
    When User input field forms scnario3
    And User verify that you have typed scnario3
    And User click button switch to ON
    And Verify switch text desc has ON
    And User select dropdown Appium is awesome
    And User click button inactive
    Then Verify pop up this button active did not show
