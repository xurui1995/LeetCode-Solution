package javacode;

import org.junit.Test;

public class Solution55_JumpGame {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
    }

    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i <= max; i++) {
            if (max >= nums.length - 1) {
                return true;
            }
            max = Math.max(nums[i] + i, max);
        }
        return false;
    }
}
