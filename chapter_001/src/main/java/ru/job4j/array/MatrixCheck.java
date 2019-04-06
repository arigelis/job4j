package ru.job4j.array;

/**
 * matrix check class.
 *
 * @author me
 * @since 06.04.2019
 */
public class MatrixCheck {
    /**
     * @param data for boolean array2x
     * @return boolean
     */
    public boolean mono(final boolean[][] data) {
        boolean result = true;
        boolean tmp = data[0][0];
        boolean tmp2 = data[0][data.length - 1];
        for (int i = 1; i < data.length; i++) {
            if (data[i][i] != tmp || data[i][data.length - i - 1] != tmp2) {
                result = false;
            }
        }
        return result;
    }
}
