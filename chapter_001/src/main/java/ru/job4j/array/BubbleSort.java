package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                }
            }
        }
        return array;
    }
}
