package ru.job4j.streamapi.lambda;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.lang.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiapasonTest {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index < end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapasonTest function = new DiapasonTest();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        DiapasonTest function = new DiapasonTest();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarifmFunctionThenLogarifmResults() {
        DiapasonTest function = new DiapasonTest();
        List<Double> result = function.diapason(10, 13, x -> Math.rint(Math.log(x)));
        List<Double> expected = Arrays.asList(2D, 2D, 2D);
        assertThat(result, is(expected));
    }
}