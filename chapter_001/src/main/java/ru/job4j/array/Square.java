package ru.job4j.array;

/**
 * square   class.
 *
 * @author arigelis
 * @since 04.04.2019
 */
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = (int) Math.pow(i, 2);
        }
        return rst;
    }
}