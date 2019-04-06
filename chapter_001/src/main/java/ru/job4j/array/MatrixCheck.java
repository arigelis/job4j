package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean tmp = data[0][0];
        boolean tmp2 = data[0][data[0].length-1];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != tmp && data[i][data[i].length-1]!=tmp2) {
                return false;
            }
        }
        return result;
    }
}
