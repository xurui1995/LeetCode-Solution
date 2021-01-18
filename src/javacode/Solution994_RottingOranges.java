package javacode;

import org.junit.Test;

import java.util.Arrays;

public class Solution994_RottingOranges {

    @Test
    public void test() {
        int[][] a = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(a));
    }

    public int orangesRotting(int[][] grid) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        int ans = 0;
        int temp = -2;
        boolean find = false;
        boolean findOne = false;
        while (true) {
            find = false;
            findOne = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2 || grid[i][j] == temp + 1) {
                        for (int k = 0; k < x.length; k++) {
                            if (i + x[k] >= 0 && i + x[k] < grid.length && j + y[k] >= 0 && j + y[k] < grid[0].length &&
                                    grid[i + x[k]][j + y[k]] == 1) {
                                grid[i + x[k]][j + y[k]] = temp;
                                find = true;
                            }
                        }
                        grid[i][j] = 0;
                    } else if (grid[i][j] == 1) {
                        findOne = true;
                    }
                }
            }
            if (!find) {
                break;
            }
            ans++;
            temp--;
        }
        return findOne ? -1 : ans;
    }
}
