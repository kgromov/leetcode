package org.kgromov.intervals.task_228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 * <br>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <br>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.
 * <br>
 * Each range [a,b] in the list should be output as:
 * <br>
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                this.addRange(result, start, nums[i - 1]);
                start = nums[i];
            }
        }
        this.addRange(result, start, nums[nums.length - 1]);
        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        var solution = new SummaryRanges();
        System.out.println(Arrays.toString(nums1) + " => " + solution.summaryRanges(nums1));
        System.out.println(Arrays.toString(nums2) + " => " + solution.summaryRanges(nums2));
    }
}
