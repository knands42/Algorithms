
package org.kotlincode.patterns.twopointers

object TwoSum {
    fun execute(
        numbers: IntArray,
        target: Int,
    ): IntArray {
        val map = mutableMapOf<Int, Int>()

        numbers.forEachIndexed { idx, num ->
            if (map.contains(num)) {
                return intArrayOf(map[num]!!, idx)
            }

            val diff = target - num
            map[diff] = idx
        }

        return intArrayOf()
    }
}
