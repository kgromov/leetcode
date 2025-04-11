package org.kgromov.arrays.task_189;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Constraints:
 * <br>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class Rotate {

    public void rotate_copy(int[] nums, int k) {
        if (k < 0 || nums.length < 1) {
            throw new IllegalArgumentException("Array length or steps to swap are invalid");
        }
        int swaps = 0;
        k = k % nums.length;
        while (swaps < k) {
            int temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
            swaps++;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
