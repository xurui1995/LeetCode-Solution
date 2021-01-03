package javacode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1710_MaximumUnitsOnTruck {

    @Test
    public void test() {
        int[][] a = new int[][]{
                {1, 3},
                {2, 2},
                {3, 1}
        };

        System.out.println(maximumUnits(a, 4));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] < truckSize) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
}
