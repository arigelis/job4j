package ru.job4j.array;

/**
 * bubblesort class.
 */
public class BubbleSort {
    /**
     * @param array int[]
     * @return int[]
     */
    public int[] sort(final int[] array) {
        int iter = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 1; i < array.length - j; i++) {
                if (array[i - 1] > array[i]) {
                    int buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    i = j;
                    iter++;
                }
            }
        }
        System.out.println(iter);
        return array;
    }
}
