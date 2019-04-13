package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysUnionTest {

    @Test
    public void twoArraysUniontCorrect() {
        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{1, 2, 3, 4, 5};
        int[] arrayTotal = new int[array1.length + array2.length];
        int[] arrayResult = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        TwoArraysUnion twoArraysUnion = new TwoArraysUnion();
        arrayTotal = twoArraysUnion.unite(array1, array2);
        assertThat(arrayTotal, is(arrayResult));
    }
}