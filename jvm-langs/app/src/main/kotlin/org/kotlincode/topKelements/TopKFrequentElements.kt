package org.kotlincode.algorithms.topKelements

import java.util.*
import kotlin.collections.iterator

object TopKFrequentElements {

    fun execute(numbers: IntArray, k: Int): IntArray {
        if (numbers.isEmpty()) return intArrayOf()

        val frequencyMap = mutableMapOf<Int, Int>()

        for (num in numbers) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        for ((num, freq) in frequencyMap) {
            priorityQueue.add(num to freq)
            if (priorityQueue.size > k) {
                priorityQueue.poll()
            }
        }

        return priorityQueue.map { it.first }.toIntArray()
    }
}