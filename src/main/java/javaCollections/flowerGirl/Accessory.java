package javaCollections.flowerGirl;

import javaCollections.flowerGirl.bouquetItems.AccessoryType;

public class Accessory extends BouquetItem {

    private String name;

    public Accessory(AccessoryType accessoryType, int price) {
        super(price);
        this.name = accessoryType.getValue();
    }

    public Accessory(String[] csvBouquetItemValues) {
        this(AccessoryType.valueOf(csvBouquetItemValues[1]), Integer.parseInt(csvBouquetItemValues[2]));
    }
}
