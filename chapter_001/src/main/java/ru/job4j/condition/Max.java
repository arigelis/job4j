package ru.job4j.condition;

/**
 * Программа расчета max.
 */
public class Max {
    /**
     * Находит максимальное число.
     *
     * @param left,right параметры для сравнения.
     * @return Ответ.
     */
    public int max(int left, int right) {
        int result = (right > left) ? right : left;
        return result;
    }
}
