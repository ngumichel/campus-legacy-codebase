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

            if (items[i].quality > 50) {
                logger.info("Item is legendary. Quality is " + items[i].quality);
            } else {

                if (!items[i].name.contains("Aged Brie")
                        && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    logger.info("Item is not a Brie or Passes");

                    qualityUpdate(i, items[i].quality, 1);
                    logger.info("Decreasing item quality by one. Quality update " + items[i].quality);

                    if (items[i].name.startsWith("Conjured")) {
                        qualityUpdate(i, items[i].quality, 1);
                        logger.info("Decreasing quality by an extra one because conjured. Quality update " + items[i].quality);
                    }

                } else {
                    logger.info("Item is a Brie or Passes");

                    qualityUpdate(i, items[i].quality, -1);
                    logger.info("Increase quality by one. Quality update " + items[i].quality);

                    if (items[i].name.startsWith("Conjured")) {
                        qualityUpdate(i, items[i].quality, -1);
                        logger.info("Increase quality by an extra one because conjured. Quality update " + items[i].quality);
                    }

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            qualityUpdate(i, items[i].quality, -1);
                            logger.info("Increase backstage passes quality by an extra one because less than 11 days sellIn. Quality update " + items[i].quality);
                        }
                        if (items[i].sellIn < 6) {
                            qualityUpdate(i, items[i].quality, -1);
                            logger.info("Increase backstage passes quality by an another extra one because less than 6 days sellIn. Quality update " + items[i].quality);
                        }
                    }
                }
            }

            logger.info("Decreasing item sellIn by one");
            items[i].sellIn--;

            if (items[i].sellIn < 0) {
                if (!items[i].name.contains("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        qualityUpdate(i, items[i].quality, 1);
                        logger.info("Decreasing item quality by one. Quality update " + items[i].quality);

                        if (items[i].name.startsWith("Conjured")) {
                            qualityUpdate(i, items[i].quality, 1);
                            logger.info("Decreasing item quality by an extra one because conjured. Quality update " + items[i].quality);
                        }
                    } else {
                        items[i].quality = 0;
                        logger.info("Backstage passes quality is equal to zero because outdated. Quality update " + items[i].quality);
                    }
                } else {
                    qualityUpdate(i, items[i].quality, -1);
                    logger.info("Increase quality by another extra one because sellIn negative. Quality update " + items[i].quality);

                    if (items[i].name.startsWith("Conjured")) {
                        qualityUpdate(i, items[i].quality, -1);
                        logger.info("Increase quality by another extra one because sellIn negative and conjured. Quality update " + items[i].quality);
                    }
                }
            }
            logger.debug("Updated item: " + items[i].name + ", " + items[i].sellIn + ", " + items[i].quality);
        }
    }

    public void qualityUpdate(int i, int quality, int update) {

        if (quality > 0 && quality < 50) {
            this.items[i].quality = quality - update;
        }
    }

    public Item[] getItems() {
        return items;
    }
}