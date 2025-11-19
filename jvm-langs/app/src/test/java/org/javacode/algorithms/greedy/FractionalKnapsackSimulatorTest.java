package org.javacode.algorithms.greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionalKnapsackSimulatorTest {

    @Test
    void testFractionalKnapsack() {
        // Given
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        double expectedMaxValue = 240.0;
        
        // When
        FractionalKnapsackSimulator knapsack = new FractionalKnapsackSimulator();
        double result = knapsack.execute(values, weights, capacity);
        
        // Then
        assertEquals(expectedMaxValue, result, 0.001, "The maximum value should be 240.0");
    }
}
