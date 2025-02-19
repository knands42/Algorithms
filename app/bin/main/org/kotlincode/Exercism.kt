package org.kotlincode

object Exercism {

    fun reverseString(inputStr: String): String {
        val charArray = inputStr.toCharArray()
        var leftPointer = 0
        var rightPointer = charArray.lastIndex

        while (leftPointer < rightPointer) {
            val tmp = inputStr[leftPointer]
            charArray[leftPointer] = charArray[rightPointer]
            charArray[rightPointer] = tmp

            leftPointer++
            rightPointer++
        }

        return String(charArray)
    }
}