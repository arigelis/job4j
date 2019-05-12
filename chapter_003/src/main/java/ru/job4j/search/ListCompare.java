package ru.job4j.search;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int result = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            result = Integer.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
