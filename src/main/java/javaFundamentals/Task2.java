package javaFundamentals;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите несколько чисел через пробел: ");
        String str = in.nextLine();

        // Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        String[] numbers = str.split("\\s+");

        String numberMax = numbers[0];
        String numberMin = numbers[0];
        int num = numbers.length;
        Double[] dblArray = new Double[num];
        double middleLength;
        double sumLength = 0;
        Double[] lengthArray = new Double[num];

        for (int i = 0; i < num; i++) {

            System.out.println(numbers[i]);

            if (numbers[i].length() > numberMax.length())
                numberMax = numbers[i];

            if (numbers[i].length() < numberMin.length())
                numberMin = numbers[i];

            //перевод строкового массива в double для задания 2

            double value = Double.parseDouble(numbers[i]);
            dblArray[i] = value;

            // создаем массив из значений длины элементов
            lengthArray[i] = (double) numbers[i].length();
            sumLength = sumLength + lengthArray[i];

        }

        System.out.println("Cамое длинное число: " + numberMax + ". Длина = " + numberMax.length());
        System.out.println("Cамое короткое число: " + numberMin + ". Длина = " + numberMin.length());


        // 2. Вывести числа в порядке возрастания (убывания) значений их длины.

        Comparator lengthComparator = (Comparator) new IncreaseLengthComparator();

        Arrays.sort(dblArray, lengthComparator);
        System.out.println("Вывести числа в порядке возрастания значений их длины: " + Arrays.toString(dblArray));

        Arrays.sort(dblArray, lengthComparator.reversed());
        System.out.println("Вывести числа в порядке убывания значений их длины: " + Arrays.toString(dblArray));

        // 3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину

        //находим среднюю длину
        middleLength = sumLength / num;

        String valueOfArrayMax = numbers[0];
        String valueOfArrayMin = numbers[0];
        Integer sizeMax = 0;
        Integer sizeMin = 10000;
        char element;

        ArrayList<Character> charsOfNumbers = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

        for (int i = 0; i < num; i++) {

            if (numbers[i].length() > middleLength)
                System.out.println("Число " + numbers[i] + ". Его длина больше средней длины. Длина = " + numbers[i].length());
            if (numbers[i].length() < middleLength)
                System.out.println("Число " + numbers[i] + ". Его длина меньше средней длины. Длина = " + numbers[i].length());

            // 4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

            ArrayList<Character> uniqueValues = new ArrayList<>();


            for (int j = numbers[i].length() - 1; j >= 0; j--) {

                //добавляем новые цифры в лист
                element = numbers[i].charAt(j);


                //if (element == '0' || element == '1' || element == '2' || element == '3' || element == '4' || element == '5' || element == '6' || element == '7' || element == '8' || element == '9')
                if (charsOfNumbers.contains(element) && !uniqueValues.contains(element)) {

                    uniqueValues.add(element);
                }

                //ищем максимальное и минимальное кол-во различных цифр в числе

                if (uniqueValues.size() > sizeMax) {
                    sizeMax = uniqueValues.size();
                    valueOfArrayMax = numbers[i];
                }

                if (uniqueValues.size() < sizeMin) {
                    sizeMin = uniqueValues.size();
                    valueOfArrayMin = numbers[i];
                }

            }

        }

        System.out.println("Число = " + valueOfArrayMax + " sizeMax = " + sizeMax);
        System.out.println("Число = " + valueOfArrayMin + " sizeMin = " + sizeMin);

        // 5. Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

        ArrayList<Character> charsOfEvenNumbers = new ArrayList<>(Arrays.asList('0', '2', '4', '6', '8'));
        ArrayList<Character> charsOfOddNumbers = new ArrayList<>(Arrays.asList('1', '3', '5', '7', '9'));
        ArrayList<String> uniqueEvenValues = new ArrayList<>();
        ArrayList<String> uniqueOddValues = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            Boolean pureEven = true;

            for (int j = 0; j < numbers[i].length(); j++) {

                element = numbers[i].charAt(j);

                if (charsOfOddNumbers.contains(element)) {
                    pureEven = false;
                }

            }

            if (pureEven) {
                uniqueEvenValues.add(numbers[i]);
            } else {
                uniqueOddValues.add(numbers[i]);
            }

        }

        int quantityOfEvenNumbers = uniqueEvenValues.size();
        System.out.println(uniqueEvenValues + " : числа, содержащие только четные цифры");
        System.out.println(quantityOfEvenNumbers + " : кол-во чисел, содержащих только четные цифры");
        System.out.println(uniqueOddValues + " : оставшиеся числа");

        String uniqueOddValue = null;
        ArrayList<Character> elementsEven = new ArrayList<>();
        ArrayList<Character> elementsOdd = new ArrayList<>();

        //ищем кол-во чисел с равным кол-вом четных и нечетных цифр
        for (int i = 0; i < uniqueOddValues.size(); i++) {

            uniqueOddValue = uniqueOddValue + uniqueOddValues.get(i);

            for (int j = 0; j < uniqueOddValue.length(); j++) {

                element = uniqueOddValue.charAt(j);

                if (charsOfOddNumbers.contains(element)) {
                    elementsOdd.add(element);
                }
                if (charsOfEvenNumbers.contains(element)) {
                    elementsEven.add(element);
                }
            }

            if (elementsOdd.size() == elementsEven.size()) {
                System.out.println(uniqueOddValues.get(i) + " : Число с равным кол-вом четных и нечетных чисел");
            }

        }

        // 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

        for (int i = 0; i < num; i++) {

            ArrayList<Character> elements = new ArrayList<Character>();
            ArrayList<Character> elementsChar = new ArrayList<Character>();

            for (int j = 0; j < numbers[i].length(); j++) {

                char elementOfNumber = numbers[i].charAt(j);

                if (charsOfEvenNumbers.contains(elementOfNumber) || charsOfOddNumbers.contains(elementOfNumber)) {

                    elements.add(elementOfNumber);
                    elementsChar.add(elementOfNumber);

                }

            }

            Collections.sort(elements);

            if (elements.equals(elementsChar) && elements.size() > 1) {

                System.out.println("Число, цифры в котором идут в строгом порядке возрастания = " + numbers[i]);
                break;

            }

        }


        // 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

        for (int i = 0; i < num; i++) {

            Boolean diffNumbers = true;

            Character[] elements = new Character[numbers[i].length()];

            for (int j = 0; j < numbers[i].length(); j++) {

                elements[j] = numbers[i].charAt(j);

            }

            Arrays.sort(elements);

            for (int k = 1; k < elements.length; k++) {
                if (elements[k] == elements[k - 1]) {
                    diffNumbers = false;
                }
            }

            if (diffNumbers) {
                System.out.println("число, состоящее только из различных цифр = " + numbers[i]);
                break;
            }

        }


    }
    }
