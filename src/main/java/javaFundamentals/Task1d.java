package javaFundamentals;

public class Task1d {

    public static void main(String[] args) {

        //Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
        int length = args.length;

        if (length == 0){
            System.out.println("Please, enter several numbers as command line arguments");
        }

        int value;
        int sum=0;
        int pr=1;


        for( int i = 0; i < length; i++) {
            value = Integer.parseInt(args[i]);
            sum = sum + value;
        }
        System.out.println("Сумма: "+ sum);

        for( int i = 0; i < length; i++) {
            value = Integer.parseInt(args[i]);
            pr = pr * value;
        }
        System.out.println("Произведение: " + pr);

    }

}
