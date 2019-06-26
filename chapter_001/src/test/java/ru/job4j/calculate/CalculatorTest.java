package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculate.Calculator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Pavel Kozhukhovskii (Vempari_2@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest  {
    /**
     * Test CalculateTest.
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMinusOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.minus(1D, 1D);
        double expected = 0D;
        assertThat(result, is(expected));
    }
}
