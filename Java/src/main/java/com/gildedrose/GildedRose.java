package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (item item : items) {
            if (item.name.equals("Aged Brie")) {
                updateAgeBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePass(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else if (item.name.contains("Conjured")) {
                updateConjuredItem(item);
            } else {
                updateDefaultfItem(item);
            }
        }
    }

    private void updateAgeBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateConjuredItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateDefaultfItem(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }


}
