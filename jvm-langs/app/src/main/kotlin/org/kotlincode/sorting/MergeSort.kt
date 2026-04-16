package org.kotlincode.algorithms.sorting

object MergeSort {

    fun merge(numbers: IntArray): IntArray {
        if (numbers.isEmpty() || numbers.size == 1) return numbers

        val middle = numbers.size / 2
        val left = numbers.sliceArray(0 until middle)
        val right = numbers.sliceArray(middle until numbers.size)

        val leftSide = merge(left)
        val rightSide = merge(right)

        return merge(leftSide, rightSide)
    }

    private fun merge(arr1: IntArray, arr2: IntArray): IntArray {
        val resultArr = mutableListOf<Int>()

        var leftArrayPointer = 0
        var rightArrayPointer = 0

        while (leftArrayPointer < arr1.size && rightArrayPointer < arr2.size) {
            if (arr1[leftArrayPointer] <= arr2[rightArrayPointer]) {
                resultArr.add(arr1[leftArrayPointer])
                leftArrayPointer++
            } else {
                resultArr.add(arr2[rightArrayPointer])
                rightArrayPointer++
            }
        }

        while (leftArrayPointer < arr1.size) {
            resultArr.add(arr1[leftArrayPointer])
            leftArrayPointer++
        }

        while (rightArrayPointer < arr2.size) {
            resultArr.add(arr2[rightArrayPointer])
            rightArrayPointer++
        }

        return resultArr.toIntArray()
    }
}