package javaCollections.optionalTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        char[] number = bf.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char c : number) stack.push(Character.getNumericValue(c));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number.length; i++) stringBuilder.append(stack.pop());
        System.out.println(stringBuilder);

    }
}
