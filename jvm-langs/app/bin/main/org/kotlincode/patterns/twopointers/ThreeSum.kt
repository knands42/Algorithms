package org.kotlincode.patterns.twopointers

object ThreeSum {

    fun execute(numbers: IntArray): List<List<Int>> {
        if (numbers.size < 3) return emptyList()

        val sortedNumbers = numbers.sorted()
        val result = mutableListOf<List<Int>>()

        for (i in 0 until sortedNumbers.size - 3) {
            if (i > 0 && sortedNumbers[i] == sortedNumbers[i - 1]) continue

            var leftPointer = i + 1
            var rightPointer = sortedNumbers.size - 1

            while (leftPointer < rightPointer) {
                val sumOperation = sortedNumbers[i] + sortedNumbers[leftPointer] + sortedNumbers[rightPointer]

                when {
                    sumOperation < 0 -> leftPointer++
                    sumOperation > 0 -> rightPointer--
                    else -> {
                        result.add(listOf(sortedNumbers[i], sortedNumbers[leftPointer], sortedNumbers[rightPointer]))

                        while (leftPointer < rightPointer && sortedNumbers[rightPointer] == sortedNumbers[rightPointer - 1]) rightPointer--
                        while (leftPointer < rightPointer && sortedNumbers[leftPointer] == sortedNumbers[leftPointer + 1]) leftPointer++

                        leftPointer++
                        rightPointer--
                    }
                }
            }
        }

        return result
    }
}