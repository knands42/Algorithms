package org.javacode.patterns.prefixsum;

import java.util.HashMap;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int runningSum = 0, maxLength = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            runningSum += (nums[i] == 0) ? - 1 : 1;

            if (map.containsKey(runningSum)) {
                int previousIndex = map.get(runningSum);
                int currentLength = i - previousIndex;

                maxLength = Math.max(maxLength, currentLength);
            } else {
                map.put(runningSum, i);
            }
        }

        return maxLength;
    }
}
