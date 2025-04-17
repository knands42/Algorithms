package org.kotlincode.patterns.topKelements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class KthLargestElementInAnArrayTest {

    @Test
    fun `should find kth largest element in basic array`() {
        val numbers = intArrayOf(3, 2, 1, 5, 6, 4)
        val k = 2
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(5, result) // 2nd largest element is 5
    }

    @Test
    fun `should handle array with duplicate elements`() {
        val numbers = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
        val k = 4
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(4, result) // 4th largest element is 4
    }

    @Test
    fun `should handle array when k equals 1`() {
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        val k = 1
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(5, result) // Largest element is 5
    }

    @Test
    fun `should handle array when k equals array length`() {
        val numbers = intArrayOf(3, 2, 1, 5, 6, 4)
        val k = 6
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(1, result) // Smallest element is 1
    }

    @Test
    fun `should handle array with negative numbers`() {
        val numbers = intArrayOf(-1, -2, 0, 3, -5, 4)
        val k = 2
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(3, result) // 2nd largest element is 3
    }

    @Test
    fun `should handle array with all same elements`() {
        val numbers = intArrayOf(1, 1, 1, 1, 1)
        val k = 3
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(1, result) // All elements are 1
    }

    @Test
    fun `should handle single element array`() {
        val numbers = intArrayOf(1)
        val k = 1
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(1, result)
    }

    @Test
    fun `should return -1 for empty array`() {
        val numbers = intArrayOf()
        val k = 1
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(-1, result)
    }

    @Test
    fun `should handle array with very large numbers`() {
        val numbers = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE - 1, Int.MAX_VALUE - 2)
        val k = 2
        
        val result = KthLargestElementInAnArray.execute(numbers, k)
        
        assertEquals(Int.MAX_VALUE - 1, result)
    }
} 