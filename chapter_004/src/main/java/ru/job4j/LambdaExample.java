package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample {
    public interface funct {
        List<Double> diapason(int start, int end, Function<Double, Double> func);
    }

    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.process(5, 8, x -> 2 * x + 1);

    }

    public void process(int start, int end, Function<Double, Double> func) {
        for (int i = start; i < end; i++) {
            func.apply(start, end, x -> 2 * i + 1);
        }

    }

    public List<Double> linearFunction(int start, int end) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {

        }
        return result;
    }
}
