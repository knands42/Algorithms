package org.javacode.algorithms.slidingwindow;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacter {

    static public Integer execute(String s) {
        if (s.isEmpty()) return 0;

        HashMap<Character, Integer> charMap = new HashMap<>();

        int leftWindowPointer = 0,
                rightWindowPointer = 0,
                maxSubStringSize = 0;

        for (; rightWindowPointer < s.length(); rightWindowPointer++) {
            char charValue = s.charAt(rightWindowPointer);
            if (charMap.containsKey(charValue)) leftWindowPointer = charMap.get(charValue) + 1;

            maxSubStringSize = Math.max(maxSubStringSize, s.substring(leftWindowPointer, rightWindowPointer + 1).length());
            charMap.put(s.charAt(rightWindowPointer), rightWindowPointer);
        }

        return maxSubStringSize;
    }
}
