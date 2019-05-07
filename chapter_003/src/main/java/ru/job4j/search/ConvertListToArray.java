package ru.job4j.search;


import java.util.List;

public class ConvertListToArray {
    public int[][] toArray(List<Integer> list, int rows) {
        if (rows == 0)
            return null;
        int cells = list.size() % rows > 0 ? list.size() / rows + 1 : list.size() / rows;
        int counter = 0;
        int[][] array = new int[rows][cells];
        for (int[] tmp : array) {
            for (int i = 0; i < rows; i++) {
                if (counter < list.size()) {
                    tmp[i] = list.get(counter);
                    counter++;
                } else {
                    tmp[i] = 0;
                }
            }
        }
        return array;
    }
}