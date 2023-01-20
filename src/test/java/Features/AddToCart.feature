Feature: add to cart functionality

  Background:
    Given Navigate to Trendyol
    When Enter username and password and click login button
    Then User should be login successfully


    @Smoke
    Scenario: User should be able to add item to cart
      Given Search in item
      And Choose an item randomly
      |searchResults|
      Then Add item to cart
      |addButton|
      And Item should be appeared in cart
