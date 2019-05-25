package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class MatrixToListTest {

    @Test
    public void integerToStrem() {
        MatrixToList matrixToList = new MatrixToList();
        List result = matrixToList.integerToStrem(3, 5);
        List eqList = new ArrayList(Arrays.asList(10, 11, 12, 13, 14, 20, 21, 22, 23, 24, 30, 31, 32, 33, 34));
        Assert.assertThat(eqList, is(result));
    }
}