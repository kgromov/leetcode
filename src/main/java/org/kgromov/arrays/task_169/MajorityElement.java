package org.kgromov.arrays.task_169;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array nums of size n, return the majority element.
 * <br>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <br>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length < 1 || nums.length > 5 * 104) {
            throw new IllegalArgumentException("Invalid nums array length");
        }
        Arrays.sort(nums);
        int majorityElement = nums[0];
        int matches = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                matches++;
            } else {
                majorityElement = nums[i];
                matches = 1;
            }
            if (matches > nums.length / 2) {
                return majorityElement;
            }
        }
        return majorityElement;
    }

    public int majorityElement_collections(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .filter(e -> e.getValue() > nums.length / 2)
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public int majorityElement_frequency(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        return Arrays.stream(nums)
                .boxed()
                .distinct()
                .map(i -> Collections.frequency(list, i))
                .filter(i -> i > nums.length / 2)
                .findFirst()
                .orElse(-1);
    }
}
