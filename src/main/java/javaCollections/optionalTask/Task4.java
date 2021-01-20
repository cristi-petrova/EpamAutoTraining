package javaCollections.optionalTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        String poem = "У меня живет козленок, " +
                "Я сама его пасу. " +
                "Я козленка в сад зеленый " +
                "Рано утром отнесу. " +
                "Он заблудится в саду — " +
                "Я в траве его найду.";

        List<String> poemWords = Arrays.asList(poem.split(" "));
        Comparator sortPoemWordsByLength = new SortStringsByLengthComparator();
        poemWords.sort(sortPoemWordsByLength);
        System.out.println(poemWords);

    }
}
