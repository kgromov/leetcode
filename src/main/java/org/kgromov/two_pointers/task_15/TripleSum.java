package org.kgromov.two_pointers.task_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <br>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class TripleSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Iterate through the array, fixing the first element of potential triplets
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Use two pointers approach to find pairs that complete the triplet
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    // Sum is too small, move left pointer to increase sum
                    left++;
                } else if (total > 0) {
                    // Sum is too large, move right pointer to decrease sum
                    right--;
                } else {
                    // Found a triplet that sums to zero
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Move both pointers inward
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        TripleSum solution = new TripleSum();
        System.out.println(solution.threeSum(nums1));
        System.out.println(solution.threeSum(nums2));
        System.out.println(solution.threeSum(nums3));
    }
}
