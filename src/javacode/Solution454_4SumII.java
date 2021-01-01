package javacode;

import java.util.*;

public class Solution454_4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {
            return 0;
        }
        int ans = 0;
        int N = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = A[i] + B[j];
                int counts = map1.getOrDefault(value, 0);
                map1.put(value, counts + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = C[i] + D[j];
                int counts = map1.getOrDefault(-value, 0);
                ans += counts;
            }
        }

        return ans;
    }

}
