package javacode;

import org.junit.Test;

public class Solution221_MaximalSquare {


    @Test
    public void test() {
        char[][] matrix = {{'1', '0', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        System.out.println(maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        ans = Math.max(dp[i][j], ans);
                        continue;
                    }
                    int n3 = matrix[i - 1][j - 1];
                    if (n3 == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        ans = Math.max(dp[i][j], ans);
                    } else {
                        dp[i][j] = 1;
                        ans = Math.max(dp[i][j], ans);
                    }
                }
            }
        }
        return ans * ans;
    }
}
