package org.kgromov.hashmap.task_219;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicates {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++)
                if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
        }
        return false;
    }

    public boolean containsNearbyDuplicateOptimized(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k <= 0) {
            return false;
        }
        Set<Integer> windowSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // If current element is already in our sliding window, we found a duplicate within k distance
            if (windowSet.contains(nums[i])) {
                return true;
            }
            // Add current element to the window
            windowSet.add(nums[i]);
            // Remove element that's outside of our k-size window
            // When i >= k, the element at i-k is now more than k distance away
            if (i >= k) {
                windowSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateSample(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = Math.min(nums.length - 1, i + k);
            while (j > i) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        var solution = new ContainsDuplicates();
        System.out.println(solution.containsNearbyDuplicateSample(nums1, k1));    // true
        System.out.println(solution.containsNearbyDuplicateSample(nums2, k2));    // true
        System.out.println(solution.containsNearbyDuplicateSample(nums3, k3));    // false
    }
}
