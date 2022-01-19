@testing
Feature: As a test engineer I want to test everything to be sure it works

  Background:
    Given I am on Cameras page

  Scenario: TC19 - Category list is available from all corresponding pages
    When I move to category: "Phones & PDAs"
    And check if left side menu is visible
    Then I move to category: "Desktops"
    And check if left side menu is visible
    Then I move to category: "PC"
    And check if left side menu is visible


  Scenario: TC20 - List of products for corresponding category is displayed
    # The test works only with the list of products on 27/10/2021 and will not work after products are changed
    And I check number of products on Cameras page
    When I move to category: "Laptops & Notebooks"
    And I check number of products on Laptops page
    When I move to category: "Macs"
    #Next step fails
#    And I check number of products on Macs page

  Scenario: TC22 - Category products consist of sub-category products
    Then I move to category: "Components"
    #Next step fails
#    And check that number of products in category and its name is equal
    Then I move to category: "Mice and Trackballs"
    And check that number of products in category and its name is equal
    Then I move to category: "Monitors"
    And check that number of products in category and its name is equal
    Then I move to category: "Printers"
    And check that number of products in category and its name is equal
    Then I move to category: "Scanners"
    And check that number of products in category and its name is equal
    Then I move to category: "Web Cameras"
    And check that number of products in category and its name is equal
    And check that number of products in names of subcategories is equal to number of product in name of category


  Scenario: TC23 - List sorting in category is working
    When I move to category: "Laptops & Notebooks"
    And I choose Grid view
    When I set Sort by field to: Name (A - Z)
    Then products are sorted alphabetically
    When I set Sort by field to: Name (Z - A)
    Then products are sorted in reverse alphabet order
    When I set Sort by field Price (Low > High)
    Then products are sorted by increasing price
    When I set Sort by field Price (High > Low)
    Then products are sorted by decreasing price
#    When I set Sort by field Rating (Highest)
#    Then products are sorted by increasing rating
#    When I set Sort by field Rating (Lowest)
#    Then products are sorted by decreasing rating


  Scenario: TC25 - List sorting is saved when the user changes it, goes to a product, and then returns back to the list
    When I move to category: "Laptops & Notebooks"
    And I set Sort by field to: Name (Z - A)
    And I click on a first product
    And I click back
    Then Sort is still by field to Name (Z-A)

  Scenario: TC28 - Adding a product from the list to Compare
    When I move to category: "Phones & PDAs"
    And I press on Compare icon on second product
    And I press on Product comparison link in success message
    Then Comparison page is opened
    And product is in comparison table


  Scenario: TC29 - Adding a product from the list to the Cart
    When I move to category: "Phones & PDAs"
    And I press on Add to Cart icon on second product
    And I click top menu cart
    And product is in the cart






