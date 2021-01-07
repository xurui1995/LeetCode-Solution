package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution870_AdvantageShuffle {

    @Test
    public void test() {
        int[] A = {2, 7, 11, 15}, B = {1, 10, 4, 11};
        System.out.println(Arrays.toString(advantageCount(A, B)));
        int[] C = {12, 24, 8, 32}, D = {13, 25, 32, 11};
        System.out.println(Arrays.toString(advantageCount(C, D)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            int index = biSearch(list, B[i]);
            if (index == -1) {
                ans[i] = list.get(0);
                list.remove(0);
            } else {
                ans[i] = list.get(index);
                list.remove(index);
            }
        }
        return ans;
    }

    private int biSearch(List<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) > target && list.get(mid - 1) <= target) {
                return mid;
            } else if (list.get(mid) > target) {
                j = mid;
            } else {
                i = mid;
            }
        }

        if (list.get(i) > target) {
            return i;
        }
        if (list.get(j) > target && list.get(j - 1) <= target) {
            return j;
        }
        return -1;
    }
}
