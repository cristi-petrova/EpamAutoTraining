package by.cristina.javaFundamentals;

import java.util.Comparator;

public class IncreaseLengthComparator implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {

        return String.valueOf(o1).length() - String.valueOf(o2).length();

    }
}
