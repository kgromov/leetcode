package org.kgromov.hashmap.task_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * <br>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <br>
 * You can return the answer in any order.
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] pair = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                pair[0] = i;
                pair[1] = map.get(target - nums[i]);
                return pair;
            }
            map.put(nums[i], i);
        }
        return pair;
    }

    public static void main(String[] args) {
        var solution = new TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int[] nums4 = {4, 3, 2};
        System.out.println(Arrays.toString(solution.twoSum(nums1, 9)) + " = [0,1]");
        System.out.println(Arrays.toString(solution.twoSum(nums2, 6)) + " = [1,2]");
        System.out.println(Arrays.toString(solution.twoSum(nums3, 6)) + " = [0,1]");
        System.out.println(Arrays.toString(solution.twoSum(nums4, 6)) + " = [0,2]");
    }
}
