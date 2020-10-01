package by.cristina.javaFundamentals;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Task1e {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число месяца: ");
        int num = in.nextInt();


        Month mnth = Month.of(num);

        Locale loc = Locale.forLanguageTag("ru");
        System.out.println("Это месяц " + mnth.getDisplayName(TextStyle.FULL_STANDALONE, loc));

        in.close();

    }

}
