Feature: Search Saucedemo

  Background:
    Given user navigates to https://www.saucedemo.com/

    Scenario: After login, view products page
      Given user enters credentials for standard user
      When clicks on Login
      Then user views product page

    Scenario: On products page, navigate to About page
      Given user logs in to https://www.saucedemo.com/
      When clicks on burguer menu in the corner
      And clicks on About tab
      Then user views About page

    Scenario Outline : Order products by price, add them to cart, number of items is updated
      Given user logs in to https://www.saucedemo.com/
      When filters products by price (low to high)
      And adds the <productNumber> most expensive products to the cart
      Then the <productNumber> of added products will be reflected on the cart icon

      Examples:
        | productNumber    |
        | 4                |