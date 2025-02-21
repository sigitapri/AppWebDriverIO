@regression @login
Feature: Login web driver io
  Scenario: Successful Login flow via Login button
    Given The user opens app web driver io
    When User click login navigation
    And User input email "user.saya@mail.com"
    And User input password "Saya123!"
    And User click button login
    Then Verify login success

  Scenario: Successful Login flow via Login button invalid email format
    Given The user opens app web driver io
    When User click login navigation
    And User input invalid email format "user.saya@mail"
    And User input password "Saya123!"
    And User click button login
    Then Verify failed login message invalid email format shown

  Scenario: Successful Login flow via Login button invalid password format
    Given The user opens app web driver io
    When User click login navigation
    And User input invalid email format "user.saya@mail.com"
    And User input password format "Say!"
    And User click button login
    Then Verify failed login message invalid password format shown