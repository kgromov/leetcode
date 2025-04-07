package org.kgromov.arrays.task_26;

/**
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length > 3 * Math.pow(10, 4)) {
            throw new IllegalArgumentException("Invalid input array length = " + nums.length);
        }
        int uniqueElements = 1;
        int uniqueElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                throw new IllegalStateException("Array is not sorted in ascending order");
            }
            if (nums[i] != uniqueElement) {
                nums[uniqueElements++] = nums[i];
                uniqueElement = nums[i];
            }
        }
        return uniqueElements;
    }

    public int removeDuplicates_others(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;

        while (j < n) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
