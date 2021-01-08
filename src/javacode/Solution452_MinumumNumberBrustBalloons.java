package javacode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452_MinumumNumberBrustBalloons {

    @Test
    public void test() {
        int[][] points = new int[][]{
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int ans = 0;
        int index = 0;
        while (index < points.length) {
            if (index == points.length - 1) {
                ans++;
                index++;
            } else {
                int shootValue = points[index][1];
                ans++;
                while (index < points.length && points[index][0] <= shootValue && points[index][1] >= shootValue) {
                    index++;
                }
            }
        }
        return ans;
    }

}
