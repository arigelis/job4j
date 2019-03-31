package ru.job4j.condition;

/**
 * Калькулятор координат.
 */
public class Point {
    /**
     * Считаем дистанцию на оси координат.
     *
     * @param x1,x2,y1,y2 .
     * @return distance.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
