package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
//        int duplicatesFound = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length - duplicatesFound; j++) {
//                if (array[i].equals(array[j])) {
//                    while (j != array.length - duplicatesFound - 1 && array[array.length - duplicatesFound - 1].equals(array[j])) {
//                        duplicatesFound++;
//                    }
//
//                    String buf = array[array.length - duplicatesFound - 1];
//                    array[array.length - duplicatesFound - 1] = array[j];
//                    array[j] = buf;
//                    duplicatesFound++;
//                }
//            }
//        }
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
