package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean tmp = data[0][0];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != tmp) {
                return false;
            }
        }
        return result;
    }
}
