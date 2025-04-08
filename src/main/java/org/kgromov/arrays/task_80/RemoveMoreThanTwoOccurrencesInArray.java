package org.kgromov.arrays.task_80;

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
public class RemoveMoreThanTwoOccurrencesInArray {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length > 3 * Math.pow(10, 4)) {
            throw new IllegalArgumentException("Invalid input array length = " + nums.length);
        }
        int uniqueElements = 1;
        int currentElementValue = nums[0];
        int occurrences = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                throw new IllegalStateException("Array is not sorted in ascending order");
            }
            if (nums[i] == currentElementValue) {
                ++occurrences;
            } else {
                occurrences = 1;
            }
            if (nums[i] != currentElementValue || occurrences <= 2) {
                nums[uniqueElements++] = nums[i];
                currentElementValue = nums[i];
            }
        }
        return uniqueElements;
    }

    public int removeDuplicates_optimized(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int cur = 0;
        boolean twice = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[cur]) {
                cur++;
                nums[cur] = nums[i];
                twice = false;
            } else {
                if (!twice) {
                    cur++;
                    nums[cur] = nums[i];
                    twice = true;
                }
            }
        }
        return cur + 1;
    }
}
