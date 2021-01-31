package javacode;

public class Solution1744_EatCandy {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }

        boolean[] ans = new boolean[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int fType = query[0];
            int fDay = query[1];
            int maxDayEat = query[2];

            long minNeedEat = sum[fType] + 1 - maxDayEat;
            long maxNeedEat = sum[fType + 1] - 1;

            long maxEat = 1l * maxDayEat * fDay;

            // System.out.println(minNeedEat);
            // System.out.println(maxNeedEat);
            // System.out.println(fDay);
            // System.out.println(maxEat);
            if (fDay > maxNeedEat) {
                i++;
                continue;
            }
            if (maxEat < minNeedEat) {
                i++;
                continue;
            }
            ans[i] = true;
            i++;

        }

        return ans;
    }
}
