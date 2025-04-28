package org.kgromov.hashmap.task_128;

import java.util.Arrays;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <br>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxSequence = 1;
        int currentSequence = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = Math.abs(nums[i + 1] - nums[i]);
            if (diff == 1) {
                currentSequence++;
                maxSequence = Math.max(currentSequence, maxSequence);
            } else if (diff > 1) {
                currentSequence = 1;

            }
        }
        return maxSequence;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {1, 0, 1, 2};
        int[] nums4 = {0, 0};
        int[] nums5 = {9,1,4,7,3,-1,0,5,8,-1,6};
        var solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(nums1));
        System.out.println(solution.longestConsecutive(nums2));
        System.out.println(solution.longestConsecutive(nums3));
        System.out.println(solution.longestConsecutive(nums4));
        System.out.println(solution.longestConsecutive(nums5));
    }
}
