package org.javacode.algorithms.basics;

import java.util.HashSet;
import java.util.Optional;
import java.util.PriorityQueue;

public class ArrayManipulation {

    public static Integer findTheSecondLargestNumber(int[] numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : numbers) {
            queue.add(num);
            if (queue.size() > 2) queue.poll();
        }

        return queue.peek();
    }

    public static void rotateArray(int[] nums, int k) {
        class Helper {
            static void reverse(int[] nums, int start, int end) {
                while (start < end) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;

                    start++;
                    end--;
                }
            }
        }

        Helper.reverse(nums, 0, nums.length - 1);
        Helper.reverse(nums, 0, nums.length - 1 - k);
        Helper.reverse(nums, nums.length - k, nums.length - 1);
    }

    public static Optional<Integer> findMissingNumberInAConsecutiveArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int valueToLookFor = nums[i - 1] + 1;
            if (valueToLookFor != nums[i]) {
                return Optional.of(valueToLookFor);
            }
        }

        return Optional.empty();
    }

    public static void moveZeros(int[] nums) {
        int zeroPosition = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[zeroPosition++] = num;
            }
        }

        while (zeroPosition < nums.length) {
            nums[zeroPosition++] = 0;
        }
    }

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> finalResult = new HashSet<>();

        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num)) finalResult.add(num);
        }

        return finalResult.stream().mapToInt(Integer::intValue).toArray();
    }
}
