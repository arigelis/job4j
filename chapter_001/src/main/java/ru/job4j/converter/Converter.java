package ru.job4j.converter;


/**
 * Конвертор валюты.
 */
public class Converter {

    private final int rubleToDollarRate = 60;
    private final int rubleToEuroRate = 70;
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / rubleToEuroRate;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / rubleToDollarRate;
    }
    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * rubleToEuroRate;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value * rubleToDollarRate;
    }
}