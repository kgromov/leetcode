package org.kgromov.arrays.task_88;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <br>
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class SortedArraysMerger {

    public void merge_with_arrays(int[] nums1, int m, int[] nums2, int n) {
        int resultLength = n + m;
        if (resultLength != nums1.length || n != nums2.length || resultLength == 0 || resultLength > 200 || n == 0) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge_with_arrays_optimized(int[] nums1, int m, int[] nums2, int n) {
        int resultLength = n + m;
        if (resultLength != nums1.length || n != nums2.length || resultLength == 0 || resultLength > 200 || n == 0) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        if (m > 0 || nums1[m - 1] >= nums2[0]) {
            Arrays.sort(nums1);
        }
    }


    // other solutions (< 1 ms)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = nums1.length;
        int[] copy1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            copy1[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n) {
            if (copy1[p1] <= nums2[p2]) {
                nums1[count] = copy1[p1];
                count++;
                p1++;
            } else {
                nums1[count] = nums2[p2];
                count++;
                p2++;
            }
        }
        if (p1 < m) {
            for (int i = p1; i < m; i++) {
                nums1[count] = copy1[i];
                count++;
            }
        }
        if (p2 < n) {
            for (int i = p2; i < n; i++) {
                nums1[count] = nums2[i];
                count++;
            }
        }

    }
}
