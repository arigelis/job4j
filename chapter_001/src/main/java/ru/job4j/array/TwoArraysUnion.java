package ru.job4j.array;

public class TwoArraysUnion {

    public int[] unite(int[] array1, int[] array2) {

        int[] arrayTotal = new int[array1.length + array2.length];
//        System.arraycopy(array1, 0, arrayTotal, 0, array1.length);
//        System.arraycopy(array2, 0, arrayTotal, array1.length, array2.length);
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arrayTotal);
        merge(array1, array2, arrayTotal);
        return arrayTotal;
    }

    private int[] merge(int[] a1, int[] a2, int[] a3) {
        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {
            if (i > a1.length - 1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }
        return a3;
    }
}

