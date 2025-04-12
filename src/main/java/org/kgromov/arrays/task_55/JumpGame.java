package org.kgromov.arrays.task_55;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <br>
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // The furthest position we can reach
        int maxReach = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If we can't reach the current position, return false
            if (i > maxReach) {
                return false;
            }
            // Update the furthest position we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can already reach the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        // We've gone through the entire array and reached the end
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0};
        int[] nums4 = {2, 5, 0, 0};
        JumpGame game = new JumpGame();
        boolean finish = game.canJump(nums);
        boolean finish2 = game.canJump(nums2);
        boolean finish3 = game.canJump(nums3);
        boolean finish4 = game.canJump(nums4);
    }
}
