package org.kgromov.arrays.task_27;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <br>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * <br>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <br>
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElementInArray {

    public int removeElement(int[] nums, int val) {
        int k = 0; // Position to place next non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0 || nums.length > 100 || val <= 0 || val > 100) {
            throw new IllegalArgumentException("Invalid input arguments nums.length = %s or val to remove = %s"
                    .formatted(nums.length, val));
        }
        nums = Arrays.stream(nums).filter(i -> i != val).toArray();
        return nums.length;
    }

    public int removeElement2(int[] nums, int val) {
        if (nums.length == 0 || nums.length > 100 || val <= 0 || val > 100) {
            throw new IllegalArgumentException("Invalid input arguments nums.length = %s or val to remove = %s"
                    .formatted(nums.length, val));
        }
        int[] copy = new int[nums.length];
        int[] indexesToRemain = new int[nums.length];
        int remainingElements = 0;
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            if (nums[i] != val) {
                indexesToRemain[i] = i;
                ++remainingElements;
            } else {
                indexesToRemain[i] = -1;
            }
        }
        nums = new int[remainingElements];
        int j = 0;
        for (int i = 0; i < copy.length; i++) {
            if (indexesToRemain[i] >= 0) {
                nums[j++] = copy[indexesToRemain[i]];
            }
        }
        return remainingElements;
    }
}
