package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author arigelis
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  *  ")
                                .append(" * * ")
                                .append("*****")
                                .toString()
                )
        );
    }
}
