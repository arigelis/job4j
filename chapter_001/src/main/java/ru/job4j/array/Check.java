package ru.job4j.array;

/**
 *class for checking.
 *since 06.04.2019
 */
public class Check {
    /**
     * @param data boolean
     * @return boolean
     */
    public boolean mono(final boolean[] data) {
        boolean result;
        result = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
