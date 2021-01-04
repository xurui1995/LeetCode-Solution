package javacode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution875_KokoEatingBananas {

    @Test
    public void test() {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int start = 1;
        int end = findMax(piles);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (canFinish(piles, H, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (canFinish(piles, H, start)) {
            return start;
        }
        if (canFinish(piles, H, end)) {
            return end;
        }
        return -1;
    }

    private boolean canFinish(int[] piles, int H, int K) {
        int times = 0;
        for (int i = 0; i < piles.length; i++) {
            times += piles[i] / K;
            if (piles[i] % K != 0) {
                times++;
            }
        }
        return times <= H;
    }

    private int findMax(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
