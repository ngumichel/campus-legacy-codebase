package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void itemQualityShouldDecreaseByOne() {
        Item[] items = new Item[] { new Item("item", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void itemQualityShouldDecreaseByTwo() {
        Item[] items = new Item[] { new Item("item", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void backstageQualityShouldIncreaseByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void backstageQualityShouldIncreaseByThree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(13);
    }

    @Test
    void backstageQualityShouldBeEqualToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void brieQualityShouldIncreaseByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void brieQualityShouldIncreaseByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    void sulfurasQualityShouldNotDecrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void conjuredItemQualityShouldDecreaseByTwo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void conjuredItemQualityShouldDecreaseByFour() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void conjuredBrieQualityShouldIncreaseByTwo() {
        Item[] items = new Item[] { new Item("Conjured Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void conjuredBrieQualityShouldIncreaseByFour() {
        Item[] items = new Item[] { new Item("Conjured Aged Brie", -2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(14);
    }

    @Test
    void itemQualityShouldNeverBeNegative() {
        Item[] items = new Item[] { new Item("Conjured", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void itemQualityShouldNotBeOverFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void itemShouldBeLegendary() {
        Item[] items = new Item[] { new Item("item", 5, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(60);
    }

}
