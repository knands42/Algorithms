package org.kotlincode.patterns.slidingwindow

import kotlin.math.max

class LongestSubStringWithoutRepeatingCharacter {

    fun execute(s: String): Int {
        if (s.length == 1) return 1

        var maxSubstringSize = 0
        val map = mutableMapOf<Char, Int>()

        var window = Pair(0, 1)

        for ((i, char) in s.withIndex()) {
            if (window.second > s.length) break

            if (map.contains(char)) window = Pair(map[char]!! + 1, window.second)

            maxSubstringSize = max(maxSubstringSize, s.substring(window.first..<window.second).count())
            window = Pair(window.first, window.second + 1)
            map[char] = i
        }

        return maxSubstringSize
    }
}