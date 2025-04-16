package org.kgromov.arrays.task_274;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher
 * received for their ith paper, return the researcher's h-index.
 * <br>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such
 * that the given researcher has published at least h papers that have each been cited at least h times.
 */
public class hIndex {

    public int hIndex(int[] citations) {
        if (citations.length == 1) {
            return 1;
        }
        int sum = 0;
        for (int citation : citations) {
            sum += citation;
        }
        int avg = sum / citations.length;
        int index = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < citations.length; i++) {
            int diff = Math.abs(avg - citations[i]);
            if (diff == 0) {
                return citations[i];
            } else {
                minDiff = Math.min(minDiff, diff);
                index = i;
            }
        }
        return citations[index];
    }

    public int hIndex_optimal(int[] citations) {
        if (citations.length < 1) {
            return 0;
        }
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations); // Sort in ascending order
        int n = citations.length;

        // Binary search to find h-index
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int h = n - mid; // Potential h-index

            if (citations[mid] >= h) {
                // This could be our answer, but we might find a better one
                right = mid;
            } else {
                // This is definitely not our answer
                left = mid + 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        hIndex hIndex = new hIndex();
        int[] nums = {3, 0, 6, 1, 5};
        int[] nums2 = {1, 3, 1};
        System.out.println(hIndex.hIndex2(nums));
        System.out.println(hIndex.hIndex2(nums2));
    }
}