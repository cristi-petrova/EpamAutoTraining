package javaFundamentals;

import java.util.Comparator;

public class ShiftColumnsInMatrix implements Comparator<double[]> {
    private int _indexToCompare;

    public ShiftColumnsInMatrix(int indexToCompare)
    {
        _indexToCompare=indexToCompare;
    }

    @Override
    public int compare(double[] o1, double[] o2) {
        return (int)(10000.0*( o1[_indexToCompare]-o2[_indexToCompare]));
    }

}
