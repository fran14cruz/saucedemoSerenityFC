Feature: Search Saucedemo

  Background:
    Given user navigates to https://www.saucedemo.com/

    Scenario: After login, view products page
      Given user enters credentials for standard user
      When clicks on Login
      Then user views Products page

    Scenario: On products page, navigate to About page and return
      Given user logs in to https://www.saucedemo.com/
      When clicks on burger menu in the corner
      And clicks on About tab
      And goes back to previous page
      Then user views Products page

    Scenario Outline : Order products by price, add them to cart, number of items is updated
      Given user logs in to https://www.saucedemo.com/
      When filters products by <type>
      And adds the <productNumber> most expensive products to the cart
      Then the <productNumber> of added products is reflected on the cart icon

      Examples:
        |type           | productNumber    |
        |priceLowToHigh | 4                |

