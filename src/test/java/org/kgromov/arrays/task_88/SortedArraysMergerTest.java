package org.kgromov.arrays.task_88;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArraysMergerTest {

    private SortedArraysMerger solution;

    @BeforeEach
    void setUp() {
        solution = new SortedArraysMerger();
    }

    @Test
    void merge_with_arrays1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge_with_arrays(nums1, m, nums2, n);

        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void merge_with_arrays2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;

        solution.merge_with_arrays(nums1, m, nums2, n);

        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void merge_with_arrays3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        solution.merge_with_arrays(nums1, m, nums2, n);

        assertArrayEquals(new int[]{1}, nums1);
    }
}