package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Pavel Kozhukhovskii
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
                                .append("   ^   ")
                                .append("\n")
                                .append("  ^ ^  ")
                                .append("\n")
                                .append(" ^ ^ ^ ")
                                .append("\n")
                                .append("^ ^ ^ ^ ")
                                .toString()
                )
        );
    }
}
