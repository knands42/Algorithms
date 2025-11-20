package org.javacode.algorithms.greedy;

import java.util.ArrayList;

public class FractionalKnapsackSimulator {

    public record Item(int value, int weight, double ratio) {
        public Item(int value, int weight) {
            this(value, weight, (double) value / weight);
        }
    }

    double execute(int[] values, int[] weights, int totalCapacity) {
        if (values.length != weights.length) {
            return -1;
        }

        ArrayList<Item> ratios = getItemsWithRatio(values, weights);

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

    private ArrayList<Item> getItemsWithRatio(int[] values, int[] weights) {
        ArrayList<Item> items = new ArrayList<>();

        for  (int i = 0; i <= values.length - 1; i++) {
            Item newItem = new Item(values[i], weights[i]);
            items.add(newItem);
        }

        return sortRatios(items);
    }

    private ArrayList<Item> sortRatios(ArrayList<Item> ratios) {
        if (ratios.size() < 2) {
            return ratios;
        }

        int mid = ratios.size() / 2;

        ArrayList<Item> left = new ArrayList<>(mid);
        ArrayList<Item> right = new ArrayList<>(ratios.size() - mid);

        for (int i = 0; i < mid; i++) {
            left.add(ratios.get(i));
        }

        for (int i = mid; i < ratios.size(); i++) {
            right.add(ratios.get(i));
        }

        return mergeRatios(ratios, sortRatios(left), sortRatios(right));
    }

    private ArrayList<Item> mergeRatios(ArrayList<Item> resultArr, ArrayList<Item> leftArr, ArrayList<Item> rightArr) {
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftArr.size() && rightIndex < rightArr.size()) {
            if (leftArr.get(leftIndex).ratio >= rightArr.get(rightIndex).ratio) {
                resultArr.add(leftArr.get(leftIndex++));
            } else {
                resultArr.add(rightArr.get(rightIndex++));
            }
        }

        while (leftIndex < leftArr.size()) {
            resultArr.add(leftArr.get(leftIndex++));
        }

        while (rightIndex < rightArr.size()) {
            resultArr.add(rightArr.get(rightIndex++));
        }

        return resultArr;
    }
}
