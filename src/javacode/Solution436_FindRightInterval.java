package javacode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution436_FindRightInterval {

    @Test
    public void test() {
        int[][] a = new int[][]{
                {1, 4},
                {2, 3},
                {3, 4}
        };
        System.out.println(Arrays.toString(findRightInterval(a)));
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] ans = new int[intervals.length];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int minCannotEnd = Integer.MAX_VALUE;

        for (int i = 0; i < intervals.length; i++) {

            int start = 0;
            int end = intervals.length - 1;
            int startValue = intervals[i][0];
            int endValue = intervals[i][1];

            if (endValue >= minCannotEnd) {
                continue;
            }
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (intervals[mid][0] >= endValue) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (intervals[start][0] >= endValue) {
                ans[map.get(startValue)] = map.get(intervals[start][0]);
            } else if (intervals[end][0] >= endValue) {
                ans[map.get(startValue)] = map.get(intervals[end][0]);
            } else {
                minCannotEnd = Math.min(minCannotEnd, endValue);
            }
        }
        return ans;
    }
}
