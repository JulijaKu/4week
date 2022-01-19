Feature: testing wishlist

  Background: user is logged in
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I go to wishlist page
    Then I check the wishlist is empty

  Scenario Outline: TC5 Verify Wish List displays all items added by the User from product page

    Then I go to "<product1>" page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I check the product added is in wishlist
    Then I print the name of the first product
    Then I go to "<product2>" page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I print the name of the second product
    Then I check there are two items in the wishlist
    Then I clear wishlist


    Examples:
      | product1                                                                        | product2                                                                        |
      | http://www.demoshop24.com/index.php?route=product/product&path=18&product_id=46 | http://www.demoshop24.com/index.php?route=product/product&path=24&product_id=28 |

  Scenario: TC6 Verify Wish List displays all items added by the User  from product list page

    Then I go to phones category
    Then I set sort to default
    Then I add the first product to wishlist
    Then I print the product name
    Then I go to wishlist page
    Then I check the same product is in wishlist
    Then I print the name of the product from the wishlist
    Then I count the quantity of items in wishlist
    Then I clear wishlist

  Scenario: TC7 Verify an item is added to wish list only once from from product list page

    Then I go to phones category
    Then I set sort to default
    Then I add the first product to wishlist more than once
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I clear wishlist

  Scenario: TC8 Verify an item is added to wish list only once from from product page

    When I go to product page
    Then I click on add to wishlist button more than once
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I clear wishlist

  Scenario: TC9 Verify all items added to wish list stay there when user clicks refresh
    When I go to product page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I click refresh from wishlist page
    Then I count the quantity of items in wishlist
    Then I clear wishlist

  Scenario: TC10 Verify all items added to wish list are saved there after the user logs out and logs back in again
    When I go to product page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I click logout
    Then I click my account login
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I clear wishlist


  Scenario: TC11 verify that user can access the product page of an item in wishlist
    When I go to product page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I click on the product name to get to its page
    Then I check the name of the product
    Then I go to wishlist page
    Then I clear wishlist

  Scenario: TC12 Remove items from wishlist
    When I go to product page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I count the quantity of items in wishlist
    Then I clear wishlist
    Then I check the wishlist is empty

  Scenario: TC13 Add an item to the cart from wishlist (for items not requiring filling out mandatory fields, as this is reviewed in User Story 4)
    When I go to product page
    Then I click on add to wishlist button
    Then I go to wishlist page
    Then I add this product to cart
    Then I count the quantity of items in wishlist
    Then I go to cart to check the added product
    Then I check added product is in cart
    Then I remove the added product from cart
    Then I go to wishlist page
    Then I clear wishlist

  Scenario: TC14 Add an out-of-stock item to the  wishlist

    Then I go to the out-of-stock item page
    Then I add out-of-stock item to wishlist
    Then I go to wishlist page
    Then I check out-of-stock item is in wishlist
    Then I clear wishlist

  Scenario: TC15 Add an out of stock  item to the cart from the wishlist
    Then I go to the out-of-stock item page
    Then I add out-of-stock item to wishlist
    Then I go to wishlist page
    Then I add this product to cart
    Then I go to cart to check the added product
    Then I check out-of-stock item is in cart
    Then I check there is alert message
    Then I remove the added product from cart
    Then I go to wishlist page
    Then I clear wishlist




