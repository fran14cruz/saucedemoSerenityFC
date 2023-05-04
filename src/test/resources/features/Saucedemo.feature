Feature: Search Saucedemo

  Background:
    Given user navigates to https://www.saucedemo.com/

    Scenario: After login, view products page
      Given user enters credentials for standard user
      When clicks on Login
      Then user views Products page