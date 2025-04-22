package org.kgromov.two_pointers.task_167;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <br>
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 * <br>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <br>
 * Your solution must use only constant extra space
 */
public class TwoSum {

    public int[] twoSum_(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }
        int[] indices = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (i >= j) {
                    continue;
                }
                if (numbers[i] + numbers[j] == target) {
                    indices[0] = i + 1;
                    indices[1] = j + 1;
                    return indices;
                }
            }
        }
        return indices;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum  == target) {
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        var solution = new TwoSum();
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 3, 4};
        int[] nums3 = {-1, 0};
        int[] nums4 = {5, 25, 75};
        System.out.println(Arrays.toString(solution.twoSum(nums1, 9)) + " = [1,2]");
        System.out.println(Arrays.toString(solution.twoSum(nums2, 6)) + " = [1,3]");
        System.out.println(Arrays.toString(solution.twoSum(nums3, -1)) + " = [1,2]");
        System.out.println(Arrays.toString(solution.twoSum(nums4, 100)) + " = [2,3]");
    }
}
