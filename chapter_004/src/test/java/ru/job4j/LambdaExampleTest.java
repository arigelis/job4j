package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LambdaExampleTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        LambdaExample lambdaExample = new LambdaExample();
        List<Double> result = lambdaExample.linearFunction(5, 8);
        //function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        LambdaExample lambdaExample = new LambdaExample();
        double result = lambdaExample.squareFunction(4, 8, 5, 5);
        //function.diapason(5, 8, x -> 2 * x + 1);
        // List<Double> expected = Arrays.asList(11D, 13D, 15D);
        double expected = 445.0;
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLinearResults() {
        LambdaExample lambdaExample = new LambdaExample();
        double result = lambdaExample.logFunction(30);
        //function.diapason(5, 8, x -> 2 * x + 1);
        // List<Double> expected = Arrays.asList(11D, 13D, 15D);
        double expected = 3.4011973816621555;
        assertThat(result, is(expected));
    }

}