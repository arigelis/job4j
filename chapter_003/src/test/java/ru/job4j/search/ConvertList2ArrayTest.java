package ru.job4j.search;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertListToArray list = new ConvertListToArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenManyMatrixInOneArray() {
        ConvertListToArray list = new ConvertListToArray();
        List<Integer> result = list.convert(
                Arrays.asList(new int[]{1, 2}, new int[]{3, 4, 5, 6, 7}));
        List<Integer> expect = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(result, is(expect));
    }
}