package org.kotlincode.patterns.slidingwindow

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumAverageSubArrayITest {

    @Test
    fun `should find maximum average in simple array`() {
        val numbers = intArrayOf(1, 12, -5, -6, 50, 3)
        val k = 4
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(12.75, result, 0.00001)
    }

    @Test
    fun `should handle array with all same numbers`() {
        val numbers = intArrayOf(5, 5, 5, 5)
        val k = 2
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(5.0, result, 0.00001)
    }

    @Test
    fun `should handle array with negative numbers`() {
        val numbers = intArrayOf(-1, -2, -3, -4, -5)
        val k = 3
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(-2.0, result, 0.00001)
    }

    @Test
    fun `should handle array with k equal to array length`() {
        val numbers = intArrayOf(1, 2, 3, 4)
        val k = 4
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(2.5, result, 0.00001)
    }

    @Test
    fun `should handle array with single element and k equals 1`() {
        val numbers = intArrayOf(5)
        val k = 1
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(5.0, result, 0.00001)
    }

    @Test
    fun `should return 0 when array size is less than k`() {
        val numbers = intArrayOf(1, 2)
        val k = 3
        
        val result = MaximumAverageSubArrayI.execute(numbers, k)
        
        assertEquals(0.0, result, 0.00001)
    }
} 