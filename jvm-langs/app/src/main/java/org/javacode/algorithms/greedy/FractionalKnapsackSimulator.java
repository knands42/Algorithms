package org.javacode.algorithms.greedy;

public class FractionalKnapsackSimulator {

    double execute(int[] values, int[] weights, int totalCapacity) {
        if (values.length != weights.length) {
            return -1;
        }

        double[] ratios = getRation(values, weights);

        int currCapacity = 0;
        double totalValue = 0;

        for (int i = 0; i <= values.length - 1; i++) {
            int newCapacity = currCapacity + weights[i];

            if (newCapacity <= totalCapacity) {
                currCapacity += weights[i];
                totalValue += values[i];
            } else {
                int remainingCapacityToFill = totalCapacity - currCapacity;
                double rationToFill = (double) remainingCapacityToFill / weights[i];
                totalValue += rationToFill * values[i];
            }
        }

        return totalValue;
    }

    private double[] getRation(int[] values, int[] weights) {
        double[] ratios = new double[values.length];

        for  (int i = 0; i <= values.length - 1; i++) {
            double ratio = values[i] / weights[i];
            ratios[i] = ratio;
        }

        return sortRatios(ratios);
    }

    private double[] sortRatios(double[] ratios) {
        if (ratios.length < 2) {
            return ratios;
        }

        int mid = ratios.length / 2;

        double[] left = new double[mid];
        double[] right = new double[ratios.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = ratios[i];
        }

        for (int i = mid; i < ratios.length; i++) {
            right[i - mid] = ratios[i];
        }

        return mergeRatios(ratios, sortRatios(left), sortRatios(right));
    }

    private double[] mergeRatios(double[] resultArr, double[] leftArr, double[] rightArr) {
        int leftIndex = 0, rightIndex = 0, currentIndexIterator = 0;

        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] >= rightArr[rightIndex]) {
                resultArr[currentIndexIterator++] = leftArr[leftIndex++];
            } else {
                resultArr[currentIndexIterator++] = rightArr[rightIndex++];
            }
        }

        while (leftIndex < leftArr.length) {
            resultArr[currentIndexIterator++] = leftArr[leftIndex++];
        }

        while (rightIndex < rightArr.length) {
            resultArr[currentIndexIterator++] = rightArr[rightIndex++];
        }

        return resultArr;
    }

}
