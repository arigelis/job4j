package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample {

    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
//        lambdaExample.process(5, 8, x -> 2 * x + 1);

    }

//    public void process(int start, int end, Function<Double, Double> func) {
//        for (int i = start; i < end; i++) {
//            func.apply(start, end, );
//        }
//    }

    public double squareFunction(int a, int b, int c, int x) {
        double result = 0;
        if (a != 0) {
            result = (Math.pow(a * x, 2) + (b * x) + c);
        }
        return result;
    }

    public List<Double> linearFunction(int start, int end) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(Double.valueOf(i * 2 + 1));
        }
        return result;
    }

    public double logFunction(int x) {
        double result = 0.0;
        result = Math.log(x);
        return result;
    }
}
