package org.javacode.patterns.prefixsum;

public class RangeSumQuery {

    private int[] sumRange;

    public RangeSumQuery(int[] nums) {
        sumRange = new int[nums.length+1];
        sumRange[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sumRange[i+1] = nums[i] + sumRange[i];
        }
    }

    public int sumRange(int left, int right) {
        return sumRange[right+1] - sumRange[left];
    }
}
