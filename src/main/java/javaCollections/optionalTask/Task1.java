package javaCollections.optionalTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.addAll;

public class Task1 {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/javaCollections/optionalTask/JavaCollectionsOptionalTask.csv";
        InputStream inputStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<String> values = new ArrayList<>();
        while (scanner.hasNextLine()){
            String[] csvValues = scanner.nextLine().split(";");
            addAll(values, csvValues);
        }

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        for (int i = values.size()-1; i >=0 ; i--) {
            byte[] buffer = values.get(i).getBytes();
            bufferedOutputStream.write(buffer);
            bufferedOutputStream.write(";\n".getBytes());
        }
        bufferedOutputStream.close();
    }
}
