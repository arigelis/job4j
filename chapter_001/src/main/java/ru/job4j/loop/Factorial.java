/**
 * Javadoc package
 */
package ru.job4j.loop;

/**
 * class for factorial calc.
 *
 * @since 03.04.2019.
 */
public class Factorial {
    /**
     * Method calc.
     * @param n input data for calculating
     * @return result
     * @since 03.04.2019.
     */
    public int calc(final int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
