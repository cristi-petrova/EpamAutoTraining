package javaCollections.flowerGirl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) throws Exception {
        String bouquetId = getBouquetIdFromUser();
        ArrayList<BouquetItem> bouquet = getBouquetFromFile(bouquetId);
        System.out.println(getBouquetPrice(bouquet) + " BYN");
        ArrayList<Flower> flowers = sortFlowersByFreshness(bouquet);
        printFlowersByFreshness(flowers);
        int[] stemLengthRange = getStemLengthRangeFromUser();
        ArrayList<Flower> flowersByStemLength = getFlowersByStemLengthRange(flowers, stemLengthRange[0], stemLengthRange[1]);
        printFlowersByStemLengthRange(flowersByStemLength);
    }

    private static String getBouquetIdFromUser() throws IOException {
        String bouquetId;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please, enter the bouquet Id:");
            bouquetId = bufferedReader.readLine();
        return bouquetId;
    }

    private static ArrayList<BouquetItem> getBouquetFromFile(String bouquetId) throws Exception {
        ArrayList<BouquetItem> bouquet = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream("src/main/resources/javaCollections/flowerGirl/Bouquet" + bouquetId + ".csv"); Scanner fileScan = new Scanner(inputStream)){
            while (fileScan.hasNextLine()){
                String[] csvBouquetItemValues = fileScan.nextLine().split(";");
                BouquetItem bouquetItem = BouquetItem.createBouquetItem(csvBouquetItemValues);
                bouquet.add(bouquetItem);
            }
        }
        return bouquet;
    }

    private static void printFlowersByStemLengthRange(ArrayList<Flower> flowersByStemLength) {
        if (flowersByStemLength.size() > 0) {
            for (Flower flower : flowersByStemLength) {
                System.out.println(flower.name + ". " + flower.getStemLength()  + "cm.");
            }
        } else {
            System.out.println("There are no flowers in the bouquet from required range.");
        }
    }

    private static int[] getStemLengthRangeFromUser() throws Exception {
        System.out.println("Enter the stem length range: ");
        int[] stemLength = new int[2];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            stemLength[0] = Integer.valueOf(bf.readLine());
            stemLength[1] = Integer.valueOf(bf.readLine());
            if (stemLength[1] < stemLength[0]) throw new Exception("The first number should be less than the second number.");
        return stemLength;
    }

    private static ArrayList<Flower> getFlowersByStemLengthRange(ArrayList<Flower> flowers, int stemLengthMin, int stemLengthMax){
        ArrayList<Flower> flowersByStemLength = new ArrayList<>();
        for (Flower flower : flowers) {
            if(flower.getStemLength() >= stemLengthMin && flower.getStemLength() <= stemLengthMax){
                flowersByStemLength.add(flower);
            }
        }
        return flowersByStemLength;
    }

    private static void printFlowersByFreshness(ArrayList<Flower> flowers){
        SimpleDateFormat sdf = new SimpleDateFormat("yy.mm.dd");
        for (Flower flower : flowers) {
            System.out.println(flower.name + " " + sdf.format(flower.getDeliveryDate()));
        }
    }

    private static ArrayList<Flower> sortFlowersByFreshness (ArrayList<BouquetItem> bouquet){
        ArrayList<Flower> flowers = new ArrayList<>();
        for(BouquetItem item : bouquet){
            if(item instanceof Flower){
                flowers.add((Flower) item);
            }
        }
        flowers.sort((o1, o2) -> (int) (o2.getDeliveryDate().getTime() - o1.getDeliveryDate().getTime()));
        return flowers;
    }

    private static int getBouquetPrice(ArrayList<BouquetItem> bouquet){
        int bouquetPrice = 0;
        for (BouquetItem item : bouquet){
            bouquetPrice += item.getPrice();
        }
        return bouquetPrice;
    }

    private static ArrayList<BouquetItem> collectBouquet(BouquetItem...items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
