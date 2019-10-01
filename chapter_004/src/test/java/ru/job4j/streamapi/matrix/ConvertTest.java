package ru.job4j.streamapi.matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertTest {
    @Test
    public void whenMatrixToList() {
        Convert convert = new Convert();
        Integer[][] matrix = new Integer[2][2];
        List<Integer> result = convert.convert(matrix);
        assertThat(result.size(), is(4));

    }
}
