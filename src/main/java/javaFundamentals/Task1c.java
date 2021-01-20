package javaFundamentals;

import java.util.Random;

public class Task1c {

    public static void main(String[] args) {

        // Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

        Random rnd = new Random(System.currentTimeMillis());

        int min = 1;
        int max = 100;
        int i;

        for (i=0; i<5; i++){

            int number = min + rnd.nextInt(max - min + 1);
            System.out.println(number);
        }

        for (i=0; i<5; i++){

            int number = min + rnd.nextInt(max - min + 1);
            System.out.print(number + " ");
        }

    }

}
