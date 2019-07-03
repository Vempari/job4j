package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax10To5Then10() {
        Max max = new Max();
        int result = max.max(10, 5);
        assertThat(result, is(10));
    }
    @Test
    public void whenMax10To5To2Then10() {
        Max max = new Max();
        int result = max.max(10, 5, 2);
        assertThat(result, is(10));
    }
    @Test
    public void whenMax10To5To15To7Then15() {
        Max max = new Max();
        int result = max.max(10, 5, 15, 7);
        assertThat(result, is(15));
    }
}