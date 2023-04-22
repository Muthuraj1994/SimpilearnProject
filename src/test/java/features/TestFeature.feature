Feature: Test Feature



Scenario Outline: Testing the findStoresWithLocation
  Given : Using Swiggy Food Application Order the food "<Location>"
  Then : Verify the Tittle of the Swiggy Food Application
  Examples:
  | Location |
  | Metukuppam |


  Scenario Outline: Testing the findProduct
    Given : Using Swiggy Food Application Order the food "<Location>"
    When : Searching the product in swiggy application "<Product>"
    Then : Verify the Tittle of the Swiggy Food Application
    Examples:
      | Location | Product |
      | Sholinganallur | soups |


    Scenario Outline: Testing the addProductToCartTest
      Given : Using Swiggy Food Application Order the food "<Location>"
      When : Searching the product in swiggy application "<Product>"
      Then : Verify the Tittle of the Swiggy Food Application
     Then : User Successfully Select the Item and Click the AddtoCard of the product
      Examples:
        | Location | Product |
        | Adyar | Chicken Rice |




