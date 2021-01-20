package javaCollections.flowerGirl;

import javaCollections.flowerGirl.bouquetItems.FlowerType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Biologic extends BouquetItem{

    int stemLength;
    Date date;
    String name;

    public Biologic(FlowerType flowerType, int price, String deliveryDate) throws ParseException {
        super(price);
        this.name = flowerType.getValue();
        this.stemLength = flowerType.getStemLength();
        SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
        date = sdf.parse(deliveryDate);
    }

    public Biologic(String[] csvBouquetItemValues) throws ParseException {
        this(FlowerType.valueOf(csvBouquetItemValues[0]), Integer.parseInt(csvBouquetItemValues[1]), csvBouquetItemValues[2]);
    }

    public void setStemLength(int leafLength) {
        this.stemLength = leafLength;
    }

    public int getStemLength() {
        return stemLength;
    }

    public Date getDeliveryDate() {
        return date;
    }

    public static BouquetItem createBiologic(FlowerType flowerType, String[] csvBouquetItemValues) throws Exception {
        switch (flowerType){
                case MATTHIOLA:
                case AMARYLLIS:
                case PAEONY:
                case ROSE:
                case CAMOMILE:
                case LILAC:
                case LILY:
                    return new Flower(csvBouquetItemValues);
                case PANICUM:
                case EUCALYPTUS:
                    return new Grass(csvBouquetItemValues);
                default: throw new Exception("Unknown flower type " + flowerType);
        }
    }
}
