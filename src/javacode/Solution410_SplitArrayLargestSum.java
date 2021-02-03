package javacode;

import org.junit.Test;

public class Solution410_SplitArrayLargestSum {

    @Test
    public void test() {
        int[] nums = {7, 2, 5, 10, 8};
        splitArray(nums, 2);

    }

    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m];

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            dp[i][0] = temp;
        }


        for (int i = 1; i < nums.length; i++) {
            for (int k = 1; k <= i && k < m; k++) {
                // dp[i][k]
                dp[i][k] = Integer.MAX_VALUE;
                temp = nums[i];
                int j = i - 1;
                while (j >= 0) {
                    int v = Math.max(temp, dp[j][k - 1]);
                    dp[i][k] = Math.min(v, dp[i][k]);

                    temp += nums[j];
                    j--;
                }

            }
        }

        return dp[nums.length - 1][m - 1];
    }

}
