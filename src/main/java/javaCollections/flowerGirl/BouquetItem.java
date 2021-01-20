package javaCollections.flowerGirl;

import javaCollections.flowerGirl.bouquetItems.FlowerType;

public abstract class BouquetItem {

    private int price;

    public BouquetItem(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price should equals zero or be more than zero");
        }
    }

    public static BouquetItem createBouquetItem(String[] csvBouquetItemValues) throws Exception {
        FlowerType flowerType = FlowerType.fromString(csvBouquetItemValues[0]);
        if(flowerType != null){
            return Biologic.createBiologic(flowerType, csvBouquetItemValues);
        } else if (csvBouquetItemValues[0].equals("Accessory")){
            return new Accessory(csvBouquetItemValues);
        } else{
            throw new Exception(csvBouquetItemValues[0] + " type is not recognized.");
        }
    }
}
