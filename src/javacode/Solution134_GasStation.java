package javacode;

public class Solution134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gaps = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            gaps[i] = gas[i] - cost[i];
        }


        int start = 0;
        int end = 1;
        int max = gaps[0];
        int maxStart = 0;
        int maxEnd = 0;
        int temp = max;

        while (end < gaps.length) {

            if (temp >= 0) {
                temp += gaps[end];

            } else {
                temp = gaps[end];
                start = end;
            }
            if (temp > max) {
                maxStart = start;
                maxEnd = end;
                max = temp;
            }
            end++;
        }


        for (int i = 0; i < start; i++) {
            if (temp >= 0) {
                temp += gaps[i];
            } else {
                temp = gaps[i];
            }
            if (temp > max) {
                maxStart = start;
                maxEnd = i;
                max = temp;
            }
        }
        // System.out.print(max);
        // System.out.print("--");
        //  System.out.print(maxStart);
        // System.out.print("--");
        //  System.out.print(maxEnd);
        // System.out.print("--");

        if (max < 0) {
            return -1;
        }

        if (maxStart <= maxEnd) {
            for (int i = maxEnd + 1; i < maxStart + gaps.length; i++) {
                max += gaps[i % gaps.length];
                if (max < 0) {
                    return -1;
                }

            }
        } else {
            for (int i = maxEnd + 1; i < maxStart; i++) {
                max += gaps[i];
                if (max < 0) {
                    return -1;
                }

            }
        }
        return maxStart;
    }
}
