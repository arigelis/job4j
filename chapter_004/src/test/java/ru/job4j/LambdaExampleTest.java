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
        List<Double> result;
        result = lambdaExample.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        LambdaExample lambdaExample = new LambdaExample();
        List<Double> result;
        result = lambdaExample.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLinearResults() {
        LambdaExample lambdaExample = new LambdaExample();
        List<Double> result;
        result = lambdaExample.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }

}