package ru.job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
//matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList())
        System.out.println(
                matrix.stream().flatMap(List::stream).collect(Collectors.toList())
        );


    }

    public List integerToStrem(int a,int b) {
        Integer[][] matrixM = new Integer[a][b];
        for (int i = 0; i < matrixM.length; i++) {
            for (int j = 0; j < matrixM[i].length; j++) {
                matrixM[i][j] = (i + 1) * 10 + j;
            }
        }
        return Stream.of(matrixM).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
