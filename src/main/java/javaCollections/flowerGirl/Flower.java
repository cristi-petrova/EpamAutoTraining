package javaCollections.flowerGirl;

import javaCollections.flowerGirl.bouquetItems.FlowerType;

import java.text.ParseException;

public class Flower extends Biologic {

    public Flower(FlowerType flowerType, int price, String deliveryDate) throws ParseException {
        super(flowerType, price, deliveryDate);
    }

    public Flower(String[] csvBouquetItemValues) throws ParseException {
        super(csvBouquetItemValues);
    }
}
