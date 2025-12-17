package gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobItemTests {
    @Test
    public void this_test_had_a_perfect_name() {
        int zeroSellIn = 0;
        int oneDaySellIn = 1;
        // Arrange
        Item[] items = new Item[] {
                new Item("itemNamePersists", 0, 0),
                new Item("sellInFloorIsZero",1,0),
                new Item("zeroSellInDecrementsByTwo",zeroSellIn, 50),
                new Item("qualityBelowZero", zeroSellIn, 0),
                new Item("qualityAboveFifty", oneDaySellIn, 52),
                new Item("qualityDecrease", oneDaySellIn, 10)
        };
        GildedRose sut = new GildedRose(items);

        // Act
        sut.updateQuality();

        // Assert
        Assertions.assertAll(
                () -> assertEquals("itemNamePersists", sut.items[0].name),
                () -> assertEquals(0, sut.items[1].sellIn),
                () -> assertEquals(48, sut.items[2].quality),
                () -> assertEquals(0, sut.items[3].quality),
                () -> assertEquals(51, sut.items[4].quality),
                () -> assertEquals(9, sut.items[5].quality)
        );

    }
}

