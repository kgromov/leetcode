package org.kgromov.two_pointers.task_11;

import java.util.Arrays;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <br>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <br>
 * Return the maximum amount of water a container can store.
 * <br>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public int maxArea_(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int width = right - left;
            int containerHeight = Math.min(heights[left], heights[right]);
            int water = width * containerHeight;
            maxWater = Math.max(maxWater, water);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public int maxArea(int[] heights) {
        int volume = (heights.length - 1) * Math.min(heights[0], heights[heights.length - 1]);
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = 1; j < heights.length; j++) {
                if (i >= j) {
                    continue;
                }
                int nextVolume = (j - i) * Math.min(heights[i], heights[j]);
                if (nextVolume > volume) {
                    volume = nextVolume;
                }
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] pipes1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] pipes2 = {1, 1};
        var solution = new ContainerWithMostWater();
        System.out.println(Arrays.toString(pipes1) + " => " + solution.maxArea(pipes1));
        System.out.println(Arrays.toString(pipes2) + " => " + solution.maxArea(pipes2));
    }
}
