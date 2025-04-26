package org.kgromov.sliding_window.task_209;

import java.util.Arrays;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to our running sum
            sum += nums[right];
            // While our sum is greater than or equal to the target
            // Try to minimize the window by moving the left pointer
            while (sum >= target) {
                // Update the minimum length
                minLength = Math.min(minLength, right - left + 1);
                // Remove the leftmost element and move left pointer
                sum -= nums[left];
                left++;
            }
        }
        // If minLength was never updated, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int minSubArrayLen_(int target, int[] nums) {
        if (target < 1 || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }
        int subArrayLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] >= target) {
                    return 1;
                }
                sum += nums[j];
                if (sum >= target) {
                    subArrayLength = Math.min((j - i) + 1, subArrayLength);
                    break;
                }
                j++;
            }
        }
        return subArrayLength == Integer.MAX_VALUE ? 0 : subArrayLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums4 = {1, 2, 3, 4, 5};
        int[] nums5 = {5};
        int[] nums6 = {1,1,1,1,7};
        var solution = new MinimumSizeSubArraySum();
        System.out.println(solution.minSubArrayLen(7, nums1));
        System.out.println(solution.minSubArrayLen(4, nums2));
        System.out.println(solution.minSubArrayLen(11, nums3));
        System.out.println(solution.minSubArrayLen(11, nums4));
        System.out.println(solution.minSubArrayLen(5, nums5));
        System.out.println(solution.minSubArrayLen(7, nums6));
    }
}
