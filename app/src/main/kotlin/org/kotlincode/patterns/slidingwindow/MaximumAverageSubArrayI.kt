package org.kotlincode.patterns.slidingwindow

import kotlin.math.max

object MaximumAverageSubArrayI {

    fun execute(numbers: IntArray, k: Int): Double {
        if (numbers.size < k) return 0.0

        var window = Pair(0, k - 1)
        var maxSum = Int.MIN_VALUE.toDouble()

        while (window.second < numbers.size) {
            val average = (numbers.sliceArray(window.first until window.second + 1).sum().toDouble()) / k

            maxSum = max(average, maxSum)

            window = Pair(window.first + 1, window.second + 1)
        }

        return maxSum
    }
}