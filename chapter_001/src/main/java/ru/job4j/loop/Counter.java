package ru.job4j.loop;
/**
 *Класс суммирует чётные числа в цикле в строго заданном диапозоне.
 */
public class Counter {
    /**
     *
     * @param start - start
     * @param finish ~
     * @return sum
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
