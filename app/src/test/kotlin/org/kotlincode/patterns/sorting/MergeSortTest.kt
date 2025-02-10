package org.kotlincode.patterns.sorting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MergeSortTest {

    @Test
    fun `should sort array in ascending order`() {
        val numbers = intArrayOf(64, 34, 25, 12, 22, 11, 90)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(11, 12, 22, 25, 34, 64, 90), result)
    }

    @Test
    fun `should handle array with duplicate elements`() {
        val numbers = intArrayOf(5, 2, 8, 5, 1, 9, 2, 8)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(1, 2, 2, 5, 5, 8, 8, 9), result)
    }

    @Test
    fun `should handle already sorted array`() {
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), result)
    }

    @Test
    fun `should handle reverse sorted array`() {
        val numbers = intArrayOf(5, 4, 3, 2, 1)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), result)
    }

    @Test
    fun `should handle array with negative numbers`() {
        val numbers = intArrayOf(-3, 4, -1, -5, 8, 2)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(-5, -3, -1, 2, 4, 8), result)
    }

    @Test
    fun `should handle single element array`() {
        val numbers = intArrayOf(1)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(1), result)
    }

    @Test
    fun `should handle empty array`() {
        val numbers = intArrayOf()
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun `should handle array with all same elements`() {
        val numbers = intArrayOf(4, 4, 4, 4, 4)
        
        val result = MergeSort.merge(numbers)
        
        assertArrayEquals(intArrayOf(4, 4, 4, 4, 4), result)
    }
} 