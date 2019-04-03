package ru.job4j.loop;

/**
 * class for factorial calc
 */
public class Factorial {
    /**
     *
     * @param n
     * @return
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result*=i;
        }
        return result;
    }
}
