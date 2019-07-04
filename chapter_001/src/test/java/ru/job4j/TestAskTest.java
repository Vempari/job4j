package ru.job4j;

import org.junit.Test;
import ru.job4j.TestAsk;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestAskTest {
    @Test
    public void mergeArrays() {
        TestAsk mergeArrays = new TestAsk();
        int[] input1 = new int[] {1, 2, 3, 4};
        int[] input2 = new int[] {5, 8, 10, 22};
        int[] result = mergeArrays.sort(input1, input2);
        int[] expect = new int[] {1, 2, 3, 4, 5, 8, 10, 22};
        assertThat(result, is(expect));
    }
    @Test
    public void mergeArraysSame() {
        TestAsk mergeArrays = new TestAsk();
        int[] input1 = new int[] {2, 2, 3, 4};
        int[] input2 = new int[] {5, 8, 10, 22};
        int[] result = mergeArrays.sort(input1, input2);
        int[] expect = new int[] {2, 2, 3, 4, 5, 8, 10, 22};
        assertThat(result, is(expect));
    }
}
