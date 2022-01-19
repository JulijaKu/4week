Feature: Wish List Test


  Scenario: Wish list is empty
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I click on top menu Wish List
    Then I am on the Wish List page
    Then I see message on the Wish List page: "Your wish list is empty."

  Scenario: TC3 Add item to Wish List and check amount of item on the top menu Wish List
  from the Product List Page
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I click on the WishList menu
    Then I clear Wish List
    Then I click on the categories menu Phone
    Then I click Add to Wish List IPhone
#    And pause
    Then I see amount of items on the top menu Wish List
#      Then I click Back button
#      Then I see another amount of items on the top menu Wish List
#      Then I click Refresh button
#      Then I see amount of items on the top menu Wish List


  Scenario: TC4 Add item to Wish List and check amount of item on the top menu Wish List
  from the Product Page
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I click on the WishList menu
    Then I clear Wish List
    Then I click on the categories menu Phone
    Then I click on IPhone
    Then I click on icon Add to Wish List
    Then I see amount of items on the top menu Wish List
#        Then I click Back button
#        Then I see another amount of items on the top menu Wish List
#        Then I click Refresh button
#        Then I see amount of items on the top menu Wish List

  Scenario:TC1 Check Wish List navigation for logged in user
    Given  I go to login page
    Then I enter my login "xayabe9074@koldpak.com"
    Then I enter my password "demopass"
    Then I click login
    Then I go to my account page
    Then I click on the WishList menu
    Then I clear Wish List
    Then I click on Testing Demo Shop
    Then I click on icon Add to Wish List on the Main Page
    Then I see amount of items on the top menu Wish List


#  Scenario:TC2 Error message with unlogged in user
#    Given I am on main page
#    Then I click on icon Add to Wish List on the Main Page
#    Then I see error message: "undefined"






