package ru.job4j.array;

public class TwoArraysUnion {

    public int[] unite(int[] array1, int[] array2) {

        int[] arrayTotal = new int[array1.length + array2.length];

        for (int i = 0; i < arrayTotal.length; i++) {
            arrayTotal[i] = array1[i / 2];
            arrayTotal[i + 1] = array2[i / 2];
            i++;
        }
        return arrayTotal;
    }
}
