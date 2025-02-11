package org.kotlincode.patterns.topKelements

import java.util.PriorityQueue

object KthLargestElementInAnArray {

    fun execute(numbers: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()

        numbers.forEach {
            heap.add(it)
            if (heap.size > k) {
                heap.poll()
            }
        }

        return heap.peek() ?: -1
    }
}