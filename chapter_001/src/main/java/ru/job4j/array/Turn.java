package ru.job4j.array;

//4,1,6,2
public class Turn {
    public int[] back(int[] array) {
        if (array.length % 2 == 0) {
            for (int i = 0; i < array.length/2; i++) {
                int buf = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = buf;
            }
        }else{
            for (int i = 0; i < array.length/2+1; i++) {
                int buf = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = buf;
            }
        }
        return array;
    }
}
