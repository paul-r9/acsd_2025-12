Feature: Gilded Rose conjured item
  “Conjured” items degrade in Quality
  twice as fast as normal items.

  Scenario: Conjured item before SellIn date
    Given The item as "Conjured Mana Bun"
    And The item has Sellin of 10
    And the item has Quality of 5
    When I update the quality
    Then I should get item with Quality of 3

  Scenario: Conjured item after SellIn date
    Given The item as "Conjured Mana Bun"
    And The item has Sellin of 0
    And the item has Quality of 10
    When I update the quality
    Then I should get item with Quality of 6
    And the item name is unchanged "Conjured Mana Bun"

  Scenario: Conjured Item sell in decreases
    Given The item as "Conjured Item"
    And The item has Sellin of 1
    When I update the quality
    Then The item has Sellin of 0
