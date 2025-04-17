package org.kotlincode.patterns.topKelements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TopKFrequentElementsTest {

    @Test
    fun `should find top k frequent elements in basic array`() {
        val numbers = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = 2
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        // 1 appears 3 times, 2 appears 2 times
        assertArrayEquals(intArrayOf(1, 2), result.sortedArray())
    }

    @Test
    fun `should handle array with all same elements`() {
        val numbers = intArrayOf(1, 1, 1, 1, 1)
        val k = 1
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        assertArrayEquals(intArrayOf(1), result)
    }

    @Test
    fun `should handle array with unique frequencies`() {
        val numbers = intArrayOf(1, 1, 2, 2, 2, 3, 3, 3, 3)
        val k = 2
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        // 3 appears 4 times, 2 appears 3 times
        assertArrayEquals(intArrayOf(2, 3), result.sortedArray())
    }

    @Test
    fun `should handle array with negative numbers`() {
        val numbers = intArrayOf(-1, -1, -2, -2, -2, 1, 1, 1, 1)
        val k = 2
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        // 1 appears 4 times, -2 appears 3 times
        assertArrayEquals(intArrayOf(-2, 1), result.sortedArray())
    }

    @Test
    fun `should handle array when k equals array length`() {
        val numbers = intArrayOf(1, 2, 3)
        val k = 3
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        assertArrayEquals(intArrayOf(1, 2, 3), result.sortedArray())
    }

    @Test
    fun `should handle array with single element`() {
        val numbers = intArrayOf(1)
        val k = 1
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        assertArrayEquals(intArrayOf(1), result)
    }

    @Test
    fun `should handle array with elements having same frequency`() {
        val numbers = intArrayOf(1, 1, 2, 2, 3, 3)
        val k = 2
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        // All elements appear twice, any two elements are valid
        assertEquals(2, result.size)
        assertTrue(result.all { it in intArrayOf(1, 2, 3) })
    }

    @Test
    fun `should return empty array for empty input`() {
        val numbers = intArrayOf()
        val k = 1
        
        val result = TopKFrequentElements.execute(numbers, k)
        
        assertArrayEquals(intArrayOf(), result)
    }
} 