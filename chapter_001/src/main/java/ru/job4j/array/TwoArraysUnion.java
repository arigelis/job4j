package ru.job4j.array;

public class TwoArraysUnion {

    public int[] unite(int[] array1, int[] array2) {

        int[] arrayTotal = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, arrayTotal, 0, array1.length);
        System.arraycopy(array2, 0, arrayTotal, array1.length, array2.length);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arrayTotal);
        return arrayTotal;
    }
}
