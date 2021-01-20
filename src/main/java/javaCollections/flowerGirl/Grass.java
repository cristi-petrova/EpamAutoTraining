package javaCollections.flowerGirl;

import javaCollections.flowerGirl.bouquetItems.FlowerType;

import java.text.ParseException;

public class Grass extends Biologic {


    public Grass(FlowerType flowerType, int price, String deliveryDate) throws ParseException {
        super(flowerType, price, deliveryDate);
    }

    public Grass(String[] csvBouquetItemValues) throws ParseException {
        super(csvBouquetItemValues);
    }
}
