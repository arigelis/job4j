package ru.job4j.calculator;
/**
 *Calculator  class
 */
public class Calculator {
    /**
     *add
     *@param first- first dig
     *@param second- second dig
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     *subtract
     *@param first- first dig
     *@param second- second dig
     */
    public double subtract(double first, double second) {
        return first - second;
    }
    /**
     *multiple
     *@param first- first dig
     *@param second- second dig
     */
    public double multiple(double first, double second) {
        return first * second;
    }
    /**
     *div
     *@param first- first dig
     *@param second- second dig
     */
    public double div(double first, double second) {
        if (second != 0) {
            return first / second;
        } else {
//            System.out.println("Делить на ноль - нельзя!");
            return 0;
        }
    }
}
