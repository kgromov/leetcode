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

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int maxReach = 0;
        int jumps = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                break;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                break;
            }
            ++jumps;
        }
        return jumps;
    }

    public int jump2(int[] nums) {
        // Edge case: if array has only one element, we're already at the end
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;          // Number of jumps needed
        int currentMax = 0;     // The furthest position we can reach with the current number of jumps
        int nextMax = 0;        // The furthest position we can reach with one more jump

        // We only need to check until the second-to-last element
        // since if we can reach the second-to-last element,
        // we can certainly reach the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the furthest position we can reach with one more jump
            nextMax = Math.max(nextMax, i + nums[i]);

            // If we've reached the limit of our current jump
            if (i == currentMax) {
                // We need to take another jump
                jumps++;
                // Update the furthest we can go with this jump
                currentMax = nextMax;

                // If we can already reach the end, no need to continue
                if (currentMax >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0};
        int[] nums4 = {2, 5, 0, 0};
        int[] nums5 = {0};
        int[] nums6 = {1, 2, 1, 1, 1};
        JumpGame game = new JumpGame();
        int jump = game.jump(nums);
        int jump2 = game.jump2(nums6);
        boolean finish = game.canJump(nums);
        boolean finish2 = game.canJump(nums2);
        boolean finish3 = game.canJump(nums3);
        boolean finish4 = game.canJump(nums4);
    }
}
