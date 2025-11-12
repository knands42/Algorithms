package org.javacode.algorithms.slidingwindow;

public class MaximumAverageSubArrayI {

    static public Double execute(int[] numbers, int k) {
        if (numbers.length < k) return 0.0;

        double maxAvgSize = Integer.MIN_VALUE;
        int leftWindowPointer = 0,
                rightWindowPointer = k - 1;
        int[] prefixSum = prefixSum(numbers);

        while (rightWindowPointer < numbers.length) {
            maxAvgSize = Math.max(maxAvgSize, calculateAvgSum(prefixSum, leftWindowPointer, rightWindowPointer, k));

            leftWindowPointer++;
            rightWindowPointer++;
        }

        return maxAvgSize;
    }

    private static int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        return prefixSum;
    }

    private static double calculateAvgSum(int[] arr, int startIdx, int endIndex, int k) {
        return (double) (arr[endIndex + 1] - arr[startIdx]) / k;
    }
}
