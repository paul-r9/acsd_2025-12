package com.gildedrose;

class GildedRose {
    private static final int _sellByThreshold = 0;
    private static final int _lastChanceWindow = 6;
    private static final int _premiumWindow = 11;
    private static final int _minQuality = 0;
    private static final int _maxQuality = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) { 
            // Decrease quality by 1 of a non-cheese and non-backstage pass item
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > _minQuality) {
                    // Decrease quality by 1
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1; 
                    }
                }
            // Increase quality variably based on selling days left
            } else {
                // Increase quality by 1
                if (items[i].quality < _maxQuality) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Increase quality by an additional 1 if there are 10 days or less
                        if (items[i].sellIn < _premiumWindow) {
                            if (items[i].quality < _maxQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                        // Increase quality by an additional 1 if there are 5 days or less
                        if (items[i].sellIn < _lastChanceWindow) {
                            if (items[i].quality < _maxQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            // Decrease sellIn by 1 for all items except Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            
            // Once the sell by date has passed
            if (items[i].sellIn < _sellByThreshold) {
                // Decrease quality by 1 of a non-cheese and non-backstage pass item
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > _minQuality) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    // Quality drops to 0 after the concert
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }

                }
                // Increase quality by 1 for cheese after sell by date
                else {
                    if (items[i].quality < _maxQuality) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
