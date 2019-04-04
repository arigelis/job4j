package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size){
        int[][] matrix = new int[size][size];
        matrix[0][0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i+1) * (j+1);
            }
        }
        return matrix;
    }
}
