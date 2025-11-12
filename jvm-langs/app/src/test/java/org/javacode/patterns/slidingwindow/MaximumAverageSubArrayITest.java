package org.javacode.patterns.slidingwindow;

import org.javacode.algorithms.slidingwindow.MaximumAverageSubArrayI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumAverageSubArrayITest {

    @Test
    public void shouldFindMaximumAverageInSimpleArray() {
        int[] numbers = { 1, 12, -5, -6, 50, 3 };
        int k = 4;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(12.75, result, 0.00001);
    }

    @Test
    public void shouldHandleArrayWithAllSameNumbers() {
        int[] numbers = { 5, 5, 5, 5 };
        int k = 2;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(5.0, result, 0.00001);
    }

    @Test
    public void shouldHandleArrayWithNegativeNumbers() {
        int[] numbers = { -1, -2, -3, -4, -5 };
        int k = 3;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(-2.0, result, 0.00001);
    }

    @Test
    public void shouldHandleArrayWithKEqualToArrayLength() {
        int[] numbers = { 1, 2, 3, 4 };
        int k = 4;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(2.5, result, 0.00001);
    }

    @Test
    public void shouldHandleArrayWithSingleElementAndKEqualsOne() {
        int[] numbers = { 5 };
        int k = 1;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(5.0, result, 0.00001);
    }

    @Test
    public void shouldReturnZeroWhenArraySizeIsLessThanK() {
        int[] numbers = { 1, 2 };
        int k = 3;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(0.0, result, 0.00001);
    }

    @Test
    public void shouldHandleArrayWithAlternatingPositiveAndNegativeNumbers() {
        int[] numbers = { 1, -1, 2, -2, 3, -3 };
        int k = 3;

        Double result = MaximumAverageSubArrayI.execute(numbers, k);

        assertEquals(1, result, 0.00001);
    }
}