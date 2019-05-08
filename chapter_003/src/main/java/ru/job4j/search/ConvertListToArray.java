package ru.job4j.search;


import java.util.List;

public class ConvertListToArray {
    public int[][] toArray(List<Integer> list, int rows) {
        if (rows == 0)
            return null;
        int cells = list.size() % rows > 0 ? list.size() / rows + 1 : list.size() / rows;
        int counterR = 0;
        int counterC = 0;
        int[][] array = new int[rows][cells];
        for (Integer tmp : list) {
            if (counterR < rows) {
                if (counterC < cells) {
                    array[counterR][counterC] = tmp;
                    counterC++;
                    if (counterC == cells) {
                        counterC = 0;
                        counterR++;
                    }
                }
            }
        }
        return array;
    }
}