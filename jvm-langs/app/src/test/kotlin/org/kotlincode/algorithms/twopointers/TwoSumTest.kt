package org.kotlincode.algorithms.twopointers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {

    @Test
    fun `should find two numbers that sum to target`() {
        val numbers = intArrayOf(2, 7, 11, 15)
        val target = 9

        val result = TwoSum.execute(numbers, target)

        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun `should find two numbers when they appear in middle of array`() {
        val numbers = intArrayOf(1, 3, 4, 5, 7, 10, 11)
        val target = 9

        val result = TwoSum.execute(numbers, target)

        assertArrayEquals(intArrayOf(2, 3), result)
    }

    @Test
    fun `should return empty array when no solution exists`() {
        val numbers = intArrayOf(1, 2, 3, 4)
        val target = 10

        val result = TwoSum.execute(numbers, target)

        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun `should work with negative numbers`() {
        val numbers = intArrayOf(-1, -2, -3, -4, 5)
        val target = 1

        val result = TwoSum.execute(numbers, target)

        assertArrayEquals(intArrayOf(3, 4), result)
    }

    @Test
    fun `should work with duplicate numbers`() {
        val numbers = intArrayOf(3, 3)
        val target = 6

        val result = TwoSum.execute(numbers, target)

        assertArrayEquals(intArrayOf(0, 1), result)
    }
} 