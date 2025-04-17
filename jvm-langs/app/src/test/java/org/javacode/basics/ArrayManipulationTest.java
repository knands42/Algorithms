package org.javacode.basics;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayManipulationTest {

    @Test
    void findTheLargestNumber_success() {
        // given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 99, 33, 3, 7, 9, 0};

        // when
        int result = ArrayManipulation.findTheSecondLargestNumber(numbers);

        // then
        assertEquals(33, result);
    }

    @Test
    void rotateArray_success() {
        // given
        int[] numbers = new int[]{1, 2, 3, 4, 2, 5, 5, 6, 7, 8, 9, 0};

        // when
        ArrayManipulation.rotateArray(numbers, 3);

        // then
        assertArrayEquals(new int[]{4, 2, 5, 5, 6, 7, 8, 9, 0, 1, 2, 3}, numbers);
    }

    @Test
    void findMissingNumberInAConsecutiveArray_success() {
        // given
        int[] numbers = new int[]{1, 2, 3, 4, 6};

        // when
        Optional<Integer> result = ArrayManipulation.findMissingNumberInAConsecutiveArray(numbers);

        // then
        assertEquals(5, result.get());
    }

    @Test
    void moveZeros_success() {
        // given
        int[] numbers = new int[]{0, 1, 0, 3, 12};

        // when
        ArrayManipulation.moveZeros(numbers);

        // then
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, numbers);
    }

    @Test
    void findIntersection_success() {
        // given
        int[] nums1 = {1, 2, 2, 1, 5};
        int[] nums2 = {2, 5, 2, 3};

        // when
        int[] result = ArrayManipulation.findIntersection(nums1, nums2);

        // then
        assertArrayEquals(new int[]{2, 5}, result);
    }
}