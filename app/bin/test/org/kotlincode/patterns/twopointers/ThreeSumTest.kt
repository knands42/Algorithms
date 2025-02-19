package org.kotlincode.patterns.twopointers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ThreeSumTest {

    @Test
    fun `should find triplets that sum to zero`() {
        val numbers = intArrayOf(-1, 0, 1, 2, -1, -4)
        
        val result = ThreeSum.execute(numbers)
        
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun `should handle array with no valid triplets`() {
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        
        val result = ThreeSum.execute(numbers)
        
        assertTrue(result.isEmpty())
    }

    @Test
    fun `should handle array with all zeros`() {
        val numbers = intArrayOf(0, 0, 0, 0)
        
        val result = ThreeSum.execute(numbers)
        
        val expected = listOf(listOf(0, 0, 0))
        assertEquals(expected, result)
    }

    @Test
    fun `should handle array with duplicate triplets but return only unique combinations`() {
        val numbers = intArrayOf(-2, 0, 1, 1, 2)
        
        val result = ThreeSum.execute(numbers)
        
        val expected = listOf(
            listOf(-2, 0, 2),
            listOf(-2, 1, 1)
        )
        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun `should handle array with negative numbers`() {
        val numbers = intArrayOf(-4, -2, -2, -1, 0, 1, 2, 3, 4)
        
        val result = ThreeSum.execute(numbers)
        
        val expected = listOf(
            listOf(-4, 0, 4),
            listOf(-4, 1, 3),
            listOf(-2, -2, 4),
            listOf(-2, -1, 3),
            listOf(-2, 0, 2),
            listOf(-1, 0, 1)
        )
        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun `should return empty list for array with less than 3 elements`() {
        val numbers = intArrayOf(1, 2)
        
        val result = ThreeSum.execute(numbers)
        
        assertTrue(result.isEmpty())
    }
} 