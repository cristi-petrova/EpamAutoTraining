package javaFundamentals;

import java.util.Scanner;

public class Task1a {

    public static void main(String[] args) {

        // Приветствовать любого пользователя при вводе его имени через командную строку;
        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter your name:\n");
        String yourName = in.next();

        System.out.printf("Hello, %s\n", yourName);

        in.close();
    }

}
