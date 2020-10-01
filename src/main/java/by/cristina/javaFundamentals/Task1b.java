package by.cristina.javaFundamentals;

import java.util.Scanner;

public class Task1b {

    public static void main(String[] args) {

        //Отобразить в окне консоли аргументы командной строки в обратном порядке.

        if (args.length == 0){
            System.out.println("Please, enter several command line arguments");
        }

        for( int i = args.length - 1 ; i >= 0 ; i--)
            System.out.println("Reverse : " + args[i]);


    }

}
