package gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (isConjured(item)) {
                updateConjuredItem(item);
            } else {
                if (doesItemGetWorseWithAge(item)) {
                    updateItemThatHGetsWorseWithAGe(item);
                } else {
                    updateBackstagePass(item);
                }

                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decrementSellIm(item);
                }

                if (item.sellIn < 0) {
                    updatePastSellIn(item);
                }
            }
        }
    }

    private static void updateConjuredItem(Item item) {
        decrementSellIm(item);
        item.quality -= 2;

        if(item.sellIn <= 0) {
            item.quality -= 2;
        }
    }

    private static void decrementSellIm(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isConjured(Item item) {
        return(item.name.contains("Conjured"));
    }

    private static boolean doesItemGetWorseWithAge(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static void updateItemThatHGetsWorseWithAGe(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
    }

    private static void updatePastSellIn(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateItemThatHGetsWorseWithAGe(item);
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1;
            }
        }
    }

    private static void updateBackstagePass(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
