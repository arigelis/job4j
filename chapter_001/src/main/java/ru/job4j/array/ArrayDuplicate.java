package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int duplicatesFound = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - duplicatesFound; j++) {
                if (array[i].equals(array[j])) {
                    while (j != array.length - duplicatesFound - 1 && array[array.length - duplicatesFound - 1].equals(array[j])) {
                        duplicatesFound++;
                    }

                    String buf = array[array.length - duplicatesFound - 1];
                    array[array.length - duplicatesFound - 1] = array[j];
                    array[j] = buf;
                    duplicatesFound++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - duplicatesFound);
    }
}
