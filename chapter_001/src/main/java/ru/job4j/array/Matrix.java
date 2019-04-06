package ru.job4j.array;

/**
 * class of matrix.
 *
 * @author me
 * @since 06.04.2019
 */
public class Matrix {
    /**
     * @param size int
     * @return int[][]
     */
    public int[][] multiple(final int size) {
        int[][] matrix = new int[size][size];
        matrix[0][0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        return matrix;
    }
}
