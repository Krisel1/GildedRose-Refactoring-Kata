package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void test_Aged_Brie_Increases_In_Quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Backstage_Passes_Increase_In_Quality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, gildedRose.items[0].quality);
        assertEquals(14, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Backstage_Passes_Increase_Faster_Near_Concert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(22, gildedRose.items[0].quality);
        assertEquals(9, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Backstage_Passes_Drop_To_Zero_After_Concert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
        assertEquals(-1, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Sulfuras_Never_Changes() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[0].quality);
        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Conjured_Items_Degrade_Twice_As_Fast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[0].quality);
        assertEquals(2, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Default_Items_Degrade_Normally() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(6, gildedRose.items[0].quality);
        assertEquals(4, gildedRose.items[0].sellIn);
    }

    @Test
    public void test_Quality_Never_Negative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void test_Quality_Never_Above_Fifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

}



