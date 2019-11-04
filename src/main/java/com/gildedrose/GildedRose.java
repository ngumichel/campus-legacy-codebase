package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public static final Logger logger = LoggerFactory.getLogger(GildedRose.class);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            logger.debug("Current item: " + items[i].name + ", " + items[i].sellIn + ", " + items[i].quality);
            if (!items[i].name.contains("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                logger.info("Item is not a Brie or Passes");
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        logger.info("Decreasing item quality by one");
                        items[i].quality = items[i].quality - 1;
                    }
                    if (items[i].name.contains("Conjured") && !items[i].name.contains("Like Conjured") && items[i].quality > 0) {
                        logger.info("Decreasing quality by an extra one because conjured");
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                logger.info("Item is a Brie or Passes");
                if (items[i].quality < 50) {
                    logger.info("Increase quality by one");
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.contains("Conjured") && !items[i].name.contains("Like Conjured") && items[i].quality < 50) {
                        logger.info("Increase quality by an extra one because conjured");
                        items[i].quality = items[i].quality + 1;
                    }

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11 ) {
                            logger.info("Increase backstage passes quality by an extra one because less than 11 days sellIn");
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            logger.info("Increase backstage passes quality by an another extra one because less than 6 days sellIn");
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("Decreasing item sellIn by one");
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.contains("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                logger.info("Decreasing item quality by one");
                                items[i].quality = items[i].quality - 1;
                            }
                            if (items[i].name.contains("Conjured") && !items[i].name.contains("Like Conjured") && items[i].quality > 0) {
                                logger.info("Decreasing item quality by an extra one because conjured");
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                        logger.info("Backstage passes quality is equal to zero because outdated");
                    }
                } else {
                    if (items[i].quality < 50) {
                        logger.info("Increase quality by another extra one because sellIn negative");
                        items[i].quality = items[i].quality + 1;
                    }
                    if (items[i].name.contains("Conjured") && !items[i].name.contains("Like Conjured") && items[i].quality < 50) {
                        logger.info("Increase quality by another extra one because sellIn negative and conjured");
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            logger.debug("Updated item: " + items[i].name + ", " + items[i].sellIn + ", " + items[i].quality);
        }
    }

    public Item[] getItems() {
        return items;
    }
}